package com.example.fitsum.controller;

import com.example.fitsum.domain.User;
import com.example.fitsum.exception.exceptions.CUserNotFoundException;
import com.example.fitsum.model_response.SingleResult;
import com.example.fitsum.model_response.repository.UserRepository;
import com.example.fitsum.service.RecordService;
import com.example.fitsum.service.ResponseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Tag(name = "record post", description = "운동 기록 API")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")

public class RecordController {

    final private RecordService recordService;

    final private UserRepository userRepository;

    final private ResponseService responseService;

    @GetMapping("/exercise/pushup")
    @Operation(summary = "푸쉬업 값 받아오기", description = "푸쉬업 값을 가져옴")
    public SingleResult saveRecordPushup(@PathVariable("pushup") String pushup){

        //user에 현재 사용자의 아이디를 저장하는 부분
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUserId(userId).orElseThrow(CUserNotFoundException::new);

        //레코드 서비스로 받아온 pushup의 값을 넘김
        recordService.saveRecordPushup(pushup);

        return responseService.getSingleResult(user.getUserItem());
    }

    @GetMapping("/exercise/squart")
    @Operation(summary = "스쿼트 값 받아오기", description = "스쿼트 값을 가져옴")
    public SingleResult saveRecordSquart(@PathVariable("squart") String squart){

        //user에 현재 사용자의 아이디를 저장하는 부분
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUserId(userId).orElseThrow(CUserNotFoundException::new);

        //레코드 서비스로 받아온 squart의 값을 넘김
        recordService.saveRecordPushup(squart);

        return responseService.getSingleResult(user.getUserItem());
    }

}