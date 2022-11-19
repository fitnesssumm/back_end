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
public class UpdateUserItemService {

    private final UserRepository userRepository;

    @Transactional
    public void UpdateUserItemDto(Integer curUserItem, Integer newUserItem){
        //controller 에서 넘어온 현재 아이템 값과 새로운 아이템 값을

        //유저 아이디를 가져와서
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();

        log.info("userId : {}" , userId);
        log.info("curUserItem : {}" , curUserItem);

        //db에서 유저를 찾아 user에 저장
        User user = userRepository.findByUserId(userId).orElseThrow(CUserNotFoundException::new);

        //해당 유저의 아이템 값을 새로운 아이템 값으로 저장
        user.setUserItem(newUserItem);


    }

}