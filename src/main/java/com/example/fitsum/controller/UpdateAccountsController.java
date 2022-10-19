package com.example.fitsum.controller;

import com.example.fitsum.Dto.UserDto;
import com.example.fitsum.model_response.CommonResult;
import com.example.fitsum.service.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "update accounts", description = "계정 변경 api")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/accounts")
public class UpdateAccountsController {

    private final UpdateNicknameService updateNicknameService;
    private final UpdateUserCoinService updateUserCoinService;
    private final UpdateUserItemService updateUserItemService;
    private final UpdateAccountsService updateAccountsService;
    private final ResponseService responseService;

    @ApiOperation(value = "유저 옷 변경", notes = "유저 옷 상태를 변경한다.")
    @PutMapping(value = "/item")
    public CommonResult updateUserItem(@RequestBody UserDto.ChangeUserItemDto changeUserItemDto) {
        updateUserItemService.UpdateUserItemDto(changeUserItemDto.getCurUserItem(), changeUserItemDto.getNewUserItem());

        return responseService.getSuccessResult();
    }

    @ApiOperation(value = "유저 코인 갯수 변경", notes = "유저 코인 갯수를 변경한다.")
    @PutMapping(value = "/coin")
    public CommonResult updateUserCoin(@RequestBody UserDto.ChangeUserCoinDto changeUserCoinDto) {
        updateUserCoinService.UpdateUserCoinDto(changeUserCoinDto.getCurUserCoin(), changeUserCoinDto.getNewUserCoin());

        return responseService.getSuccessResult();
    }

    @ApiOperation(value = "비밀번호 변경", notes = "비밀번호를 변경한다.")
    @PutMapping(value = "/password")
    public CommonResult updatePw(@RequestBody UserDto.ChangePwDto changePwDto) {
        updateAccountsService.UpdatePwDto(changePwDto.getCurPw(), changePwDto.getNewPw());

        return responseService.getSuccessResult();
    }

    @ApiOperation(value = "닉네임 변경", notes = "닉네임를 변경한다.")
    @PutMapping(value = "/nickname")
    public CommonResult updateNickname(@RequestBody UserDto.ChangenickNameDto changenickNameDto) {
        updateNicknameService.UpdateNicknameDto(changenickNameDto.getCurnickName(), changenickNameDto.getNewnickName());

        return responseService.getSuccessResult();
    }



}
