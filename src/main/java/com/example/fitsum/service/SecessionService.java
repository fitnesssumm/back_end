package com.example.fitsum.service;


import com.example.fitsum.domain.User;
import com.example.fitsum.domain.UserBoard;
import com.example.fitsum.exception.exceptions.CUserNotFoundException;
import com.example.fitsum.model_response.repository.UserBoardRepository;
import com.example.fitsum.model_response.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SecessionService {

    private final UserRepository userRepository;

    private final UserBoardRepository userBoardRepository;

    @Transactional
    public void secession(String userId) {
        User user = userRepository.findByUserId(userId).orElseThrow(CUserNotFoundException::new);

        List<UserBoard> userBoards = userBoardRepository.findAllByUser(user).get();


        for(UserBoard userBoard : userBoards){
            User likedUser = userBoard.getUser();
            userBoard.setUser(null);
            likedUser.getStoredDiaryList().remove(userBoard);
            userBoard.setBoard(null);
        }

        userRepository.deleteByUserId(userId).orElseThrow(CUserNotFoundException::new);
    }
}