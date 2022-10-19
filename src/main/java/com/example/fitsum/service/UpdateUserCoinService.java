package com.example.fitsum.service;


import com.example.fitsum.domain.User;
import com.example.fitsum.exception.exceptions.CUserNotFoundException;
import com.example.fitsum.repository.UserRepository;
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

        String userId = SecurityContextHolder.getContext().getAuthentication().getName();

        log.info("id : {}" , userId);
        log.info("userCoin : {}" , curUserCoin);

        User user = userRepository.findByUserId(userId).orElseThrow(CUserNotFoundException::new);

        user.setUserCoin(newUserCoin);


    }

}
