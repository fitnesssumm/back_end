package com.example.fitsum.service;

import com.example.fitsum.domain.Record;
import com.example.fitsum.domain.User;
import com.example.fitsum.exception.exceptions.CUserNotFoundException;
import com.example.fitsum.model_response.repository.RecordRepository;
import com.example.fitsum.model_response.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Slf4j
@RequiredArgsConstructor
@Service
public class RecordService {
    private final RecordRepository recordRepository;

    private final UserRepository userRepository;


    @Transactional
    public void saveRecordPushup(String pushup) {

        //유저 아이디를 찾아와
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();

        //DB에서 찾아 유저를 user에 저장
        User user = userRepository.findByUserId(userId).orElseThrow(CUserNotFoundException::new);

        Record record = recordRepository.save(
                Record.builder()
                        .user(user)
                        .pushup(pushup)
                        .recordDate(LocalDate.now())
                        .build()
        );
    }

    @Transactional
    public void saveRecordSquart(String squart) {
        //유저 아이디를 찾아와
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();

        //DB에서 찾아 유저를 user에 저장
        User user = userRepository.findByUserId(userId).orElseThrow(CUserNotFoundException::new);

        Record record = recordRepository.save(
                Record.builder()
                        .user(user)
                        .pushup(squart)
                        .recordDate(LocalDate.now())
                        .build()
        );
    }

}
