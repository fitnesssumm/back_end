package com.example.fitsum.controller;

import com.example.fitsum.Dto.BadgeDto;
import com.example.fitsum.Dto.BoardDto;
import com.example.fitsum.domain.Badge;
import com.example.fitsum.domain.User;
import com.example.fitsum.exception.exceptions.CAuthenticationException;
import com.example.fitsum.exception.exceptions.CUserNotFoundException;
import com.example.fitsum.exception.exceptions.CWrongBoardIdException;
import com.example.fitsum.model_response.CommonResult;
import com.example.fitsum.model_response.SingleResult;
import com.example.fitsum.repository.BadgeRepository;
import com.example.fitsum.repository.UserRepository;
import com.example.fitsum.service.BadgeService;
import com.example.fitsum.service.ResponseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "badge post", description = "뱃지 리스트 API")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BadgeController {

    private final BadgeService badgeService;

    private final ResponseService responseService;
    private final BadgeRepository badgeRepository;

    private final UserRepository userRepository;

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

        badgeService.checks(createBadgeDto);
        badgeService.createBadge(userId, createBadgeDto);

        return responseService.getSuccessResult();
    }

    @GetMapping("/profile/badge")
    @Operation(summary = "뱃지1 받아오기", description = "뱃지1을 가져옴")
    public SingleResult badgeList() {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();


        List<BadgeDto.ViewBadge> badgeViewDtoList = badgeService.getMyBadgeListByUserId(userId);

        return responseService.getSingleResult(badgeViewDtoList);
    }

    @ApiOperation(value = "뱃지 중복체크")
    @GetMapping(value = "/profile/checkbadge/{user}")
    public CommonResult checkBadge(@PathVariable  User user){
        badgeService.checkBadge(user);
        return responseService.getSuccessResult();
    }
}