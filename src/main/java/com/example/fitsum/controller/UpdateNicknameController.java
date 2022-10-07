package com.example.fitsum.controller;

import com.example.fitsum.Dto.UserDto;
import com.example.fitsum.model_response.CommonResult;
import com.example.fitsum.service.ResponseService;
import com.example.fitsum.service.UpdateAccountsService;
import com.example.fitsum.service.UpdateNicknameService;
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
public class UpdateNicknameController {

    private final UpdateNicknameService updateNicknameService;
    private final ResponseService responseService;

    @ApiOperation(value = "닉네임 변경", notes = "닉네임를 변경한다.")
    @PutMapping(value = "/nickname")
    public CommonResult updateNickname(@RequestBody UserDto.ChangenickNameDto changenickNameDto) {
        updateNicknameService.UpdateNicknameDto(changenickNameDto.getCurnickName(), changenickNameDto.getNewnickName());

        return responseService.getSuccessResult();
    }

}
