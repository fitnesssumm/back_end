package com.example.fitsum.controller;

import com.example.fitsum.domain.User;
import com.example.fitsum.exception.exceptions.CUserNotFoundException;
import com.example.fitsum.model_response.SingleResult;
import com.example.fitsum.repository.UserRepository;
import com.example.fitsum.service.ResponseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "profile image controller", description = "프로필 API")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/profile")
public class MyPageController {
    // UserService 만들었음.
    private final ResponseService responseService;
    private final UserRepository userRepository;

    @GetMapping("/mypage")
    @Operation(summary = "프로필 변경", description = "프로필을 변경함.")
    public SingleResult userNickname() {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUserId(userId).orElseThrow(CUserNotFoundException::new);
        return responseService.getSingleResult(user.getNickName());
    }

    @GetMapping("/item")
    @Operation(summary = "옷 받아오기", description = "유저의 현재 옷 을 가져옴")
    public SingleResult userItem(){
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUserId(userId).orElseThrow(CUserNotFoundException::new);
        return  responseService.getSingleResult(user.getUserItem());

    }

    @GetMapping("/coin")
    @Operation(summary = "코인 받아오기", description = "코인을 가져옴")
    public SingleResult userCoin(){
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUserId(userId).orElseThrow(CUserNotFoundException::new);
        return responseService.getSingleResult(user.getUserCoin());
    }





}
