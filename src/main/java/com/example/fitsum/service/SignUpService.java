package com.example.fitsum.service;


import com.example.fitsum.Dto.UserDto;
import com.example.fitsum.domain.User;
import com.example.fitsum.model_response.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class SignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; // 비밀번호 암호화

    @Transactional
    public void joinUser(UserDto.SignUpUserDto signUpUserDto) {
        User user = User.builder()
                .userId(signUpUserDto.getUserId())
                .userPw(passwordEncoder.encode(signUpUserDto.getUserPw()))
                .userName(signUpUserDto.getUserName())
                .email(signUpUserDto.getEmail())
                .nickName(signUpUserDto.getNickName())
                .userSex(signUpUserDto.getUserSex())
                .userItem(signUpUserDto.getUserItem())
                .emailAuth(true)
                .roles(Collections.singletonList("ROLE_USER"))
                .userCoin(0)
                .build();


        userRepository.save(user);
    }
}
