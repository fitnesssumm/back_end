package com.example.fitsum.service;


import com.example.fitsum.domain.User;
import com.example.fitsum.exception.exceptions.CUserNotFoundException;
import com.example.fitsum.model_response.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UpdateUserCoinService {

    private final UserRepository userRepository;

    @Transactional
    public void UpdateUserCoinDto(Integer curUserCoin, Integer newUserCoin){
        //controller 에서 넘어온 현재 코인 값과 새로운 코인 값을

        //유저 아이디를 찾아와
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();

        log.info("id : {}" , userId);
        log.info("userCoin : {}" , curUserCoin);

        //DB에서 찾아 유저를 user에 저장
        User user = userRepository.findByUserId(userId).orElseThrow(CUserNotFoundException::new);

        //해당 user의 코인 갯수를 새로운 코인 갯수를 넣음.
        user.setUserCoin(newUserCoin);


    }

}
