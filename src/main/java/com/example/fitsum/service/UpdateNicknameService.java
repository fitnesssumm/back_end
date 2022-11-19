package com.example.fitsum.service;


import com.example.fitsum.domain.User;
import com.example.fitsum.exception.exceptions.CCurPasswordFailedException;
import com.example.fitsum.exception.exceptions.CUserNotFoundException;
import com.example.fitsum.model_response.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static java.util.regex.Pattern.matches;

@Service
@Slf4j
@RequiredArgsConstructor
public class UpdateNicknameService {

    private final UserRepository userRepository;

    @Transactional
    public void UpdateNicknameDto(String curnickName, String newnickName){

        String userId = SecurityContextHolder.getContext().getAuthentication().getName();

//        log.info("id : {}" , userId);
//        log.info("nickname : {}" , curnickName);

        User user = userRepository.findByUserId(userId).orElseThrow(CUserNotFoundException::new);

        if (matches(curnickName, user.getPassword())) {
            throw new CCurPasswordFailedException();
        }

        user.setNickName(newnickName);


    }

}
