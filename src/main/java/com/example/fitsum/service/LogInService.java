package com.example.fitsum.service;


import com.example.fitsum.config.security.JwtTokenProvider;
import com.example.fitsum.domain.User;
import com.example.fitsum.exception.exceptions.CEmailAuthTokenNotFoundException;
import com.example.fitsum.exception.exceptions.CSigninFailedException;
import com.example.fitsum.exception.exceptions.CUserNotFoundException;
import com.example.fitsum.model_response.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class LogInService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider; // jwt 토큰 생성
    private final PasswordEncoder passwordEncoder; // 비밀번호 암호화

    @Transactional
    public void signInByLoginDto(String id, String password, HttpServletResponse response){
        //입력받은 아이디와 비밀번호

        log.info("id : {}" , id);
        log.info("password : {}" , password);

        //user에 DB에서 찾은 id에 맞는 유저 정보를 저장함
        User user = userRepository.findByUserId(id).orElseThrow(CUserNotFoundException::new);

        if (!passwordEncoder.matches(password, user.getPassword())) {
            // matches : 평문, 암호문 패스워드 비교 후 boolean 결과 return
            throw new CSigninFailedException();
        }

        //메일이 없다면 메일 없는 예외처리
        if(user.getEmailAuth() == false){
            throw new CEmailAuthTokenNotFoundException();
        }

        //액세스토큰과 리프레시 토큰 생성
        String accessToken = jwtTokenProvider.createAccessToken(user.getUserId(), user.getRoles());
        String refreshToken = jwtTokenProvider.createRefreshToken(user.getUserId(), user.getRoles());

        //response에 각 토큰들 넘겨줌
        jwtTokenProvider.setHeaderAccessToken(response, accessToken);
        jwtTokenProvider.setHeaderRefreshToken(response, refreshToken);

        //유저 db에 refreshtoken 저장
        user.setRefreshToken(refreshToken);
    }
}
