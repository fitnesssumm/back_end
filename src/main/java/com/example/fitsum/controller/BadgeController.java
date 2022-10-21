package com.example.fitsum.controller;

import com.example.fitsum.Dto.BadgeDto;
import com.example.fitsum.exception.exceptions.CAuthenticationException;
import com.example.fitsum.model_response.CommonResult;
import com.example.fitsum.service.BadgeService;
import com.example.fitsum.service.ResponseService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@Tag(name = "badge post", description = "뱃지 리스트 API")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BadgeController {

    private final BadgeService badgeService;

    private final ResponseService responseService;

    @ApiOperation(value = "뱃지 등록", notes = "뱃지를 등록한다.")
    @PostMapping(value ="/profile/{createbadge}")
    public CommonResult createBadge(@RequestBody BadgeDto.CreateBadgeDto createBadgeDto) {
        //권한을 통해 유저 id를 획득합니다.
        String userId;

        try {
            //권한을 통해 유저 id를 획득합니다.
            userId = SecurityContextHolder.getContext().getAuthentication().getName();
        } catch (NullPointerException e) {
            log.info("Not legal authentication.");
            throw new CAuthenticationException();
        }

        badgeService.createBadge(userId, createBadgeDto);

        return responseService.getSuccessResult();
    }

}