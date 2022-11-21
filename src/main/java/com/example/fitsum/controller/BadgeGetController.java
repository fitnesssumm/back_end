package com.example.fitsum.controller;


import com.example.fitsum.Dto.BadgeDto;
import com.example.fitsum.model_response.CommonResult;
import com.example.fitsum.service.ResponseService;
import com.example.fitsum.service.UpdateBadgeGetService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Tag(name = "badgeget", description = "뱃지 성공여부 리스트 API")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BadgeGetController {

    private final UpdateBadgeGetService updateBadgeGetService;

    private final ResponseService responseService;

    @ApiOperation(value = "뱃지2번 변경", notes = "뱃지2번 성공여부를 변경한다.")
    @PutMapping(value = "/profile/badge2")
    public CommonResult updateBadge2(@RequestBody BadgeDto.ChangeBadge2 changeBadge2) {
        updateBadgeGetService.UpdateBadge2(changeBadge2.getCurBadge2(), changeBadge2.getNewBadge2() );
        return responseService.getSuccessResult();

    }


    @ApiOperation(value = "뱃지3번 변경", notes = "뱃지3번 성공여부를 변경한다.")
    @PutMapping(value = "/profile/badge3")
    public CommonResult updateBadge3(@RequestBody BadgeDto.ChangeBadge3 changeBadge3) {
        updateBadgeGetService.UpdateBadge3(changeBadge3.getCurBadge3(), changeBadge3.getNewBadge3() );
        return responseService.getSuccessResult();

    }


}
