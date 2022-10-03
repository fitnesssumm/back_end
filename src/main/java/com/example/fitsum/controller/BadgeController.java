package com.example.fitsum.controller;

import com.example.fitsum.Dto.BadgeDto;
import com.example.fitsum.exception.exceptions.CAuthenticationException;
import com.example.fitsum.exception.exceptions.CWrongDiaryIdException;
import com.example.fitsum.model_response.CommonResult;
import com.example.fitsum.model_response.SingleResult;
import com.example.fitsum.service.BadgeService;
import com.example.fitsum.service.ResponseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Tag(name = "badge post", description = "뱃지 리스트 API")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BadgeController {

    final private BadgeService badgeService;

    final private ResponseService responseService;

    @GetMapping("/badge/badge-id")
    @Operation(summary = "나의 뱃지 리스트", description = "가지고 있는 뱃지 정보를 가져옴.")
    public SingleResult showBadge(@PathVariable("badge-id") String badgeIds) {
        Long badgeId;
        BadgeDto.BadgeViewDto badgeDto;

        log.info(badgeIds + "");

        try {
            badgeId = Long.parseLong(badgeIds);
            //일기장을 showdto로 보여지는 용도로만 사용
            badgeDto = badgeService.getBadgeByBadgeId(badgeId);
        } catch (CWrongDiaryIdException e) {
            throw new CWrongDiaryIdException();
        }
        return responseService.getSingleResult(badgeDto);
    }

    @PostMapping("/badge")
    @Operation(summary = "뱃지 등록", description = "제목(title)과 성공여부(Success를 이용하여 뱃지를 신규 등록합니다.")
    public CommonResult createBadge(@RequestBody BadgeDto.CollectBadgeDto collectBadgeDto) {
        //권한을 통해 유저 id를 획득합니다.
        String userId;

        try {
            //권한을 통해 유저 id를 획득합니다.
            userId = SecurityContextHolder.getContext().getAuthentication().getName();
        } catch (NullPointerException e) {
            log.info("Not legal authentication.");
            throw new CAuthenticationException();
        }

        badgeService.collectBadge(userId, collectBadgeDto);

        return responseService.getSuccessResult();
    }
}
