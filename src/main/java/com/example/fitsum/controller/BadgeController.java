package com.example.fitsum.controller;

import com.example.fitsum.Dto.BadgeDto;
import com.example.fitsum.exception.exceptions.CWrongBoardIdException;
import com.example.fitsum.model_response.CommonResult;
import com.example.fitsum.model_response.SingleResult;
import com.example.fitsum.service.BadgeService;
import com.example.fitsum.service.ResponseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Tag(name = "badge post", description = "뱃지 리스트 API")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BadgeController {

    final private BadgeService badgeService;
    final private ResponseService responseService;

    @GetMapping("/profile/{badge}")
    @Operation(summary = "나의 뱃지 리스트", description = "가지고 있는 뱃지 정보를 가져옴.")
    public SingleResult showBadge(@PathVariable("badge") String badgeIds) {
        Long badgeId;
        BadgeDto.BadgeViewDto badgeDto;

        log.info(badgeIds + "");

        try {
            badgeId = Long.parseLong(badgeIds);

            badgeDto = badgeService.getBadgeBybadgeId(badgeId);
        } catch (CWrongBoardIdException e) {
            throw new CWrongBoardIdException();
        }
        return responseService.getSingleResult(badgeDto);

    }

    @ApiOperation(value = "뱃지 등록", notes = "뱃지를 등록한다.")
    @PostMapping(value ="/profile/badgeregister")
    public CommonResult badgeregister(@RequestBody BadgeDto.CollectBadgeDto collectBadgeDto){
        log.info("badgetitle : {} " , collectBadgeDto.getBadgetitle());
        log.info("user : {}" , collectBadgeDto.getUser());

        badgeService.successBadge(collectBadgeDto);

        return responseService.getSuccessResult();
    }

    @ApiOperation(value = "badge중복확인")
    @GetMapping("/profile/checkbadge")
    public CommonResult checkBadge(@PathVariable("checkbadge") String badgetitle){
        log.info("checkBadge : {}",badgetitle);
        badgeService.checkBadge(badgetitle);
        return responseService.getSuccessResult();
    }

}