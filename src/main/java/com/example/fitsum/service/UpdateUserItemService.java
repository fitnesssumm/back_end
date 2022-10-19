package com.example.fitsum.service;


import com.example.fitsum.domain.User;
import com.example.fitsum.exception.exceptions.CCurPasswordFailedException;
import com.example.fitsum.exception.exceptions.CUserNotFoundException;
import com.example.fitsum.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static java.util.regex.Pattern.matches;

@Service
@Slf4j
@RequiredArgsConstructor
public class UpdateUserItemService {

    private final UserRepository userRepository;

    @Transactional
    public void UpdateUserItemDto(Integer curUserItem, Integer newUserItem){

        String userId = SecurityContextHolder.getContext().getAuthentication().getName();

        log.info("id : {}" , userId);
        log.info("useritem : {}" , curUserItem);

        User user = userRepository.findByUserId(userId).orElseThrow(CUserNotFoundException::new);

        user.setUserItem(newUserItem);


    }

}
