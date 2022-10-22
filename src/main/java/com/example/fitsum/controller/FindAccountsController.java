package com.example.fitsum.controller;


import com.example.fitsum.Dto.UserDto;
import com.example.fitsum.model_response.CommonResult;
import com.example.fitsum.model_response.SingleResult;
import com.example.fitsum.service.FindAccountsService;
import com.example.fitsum.service.ResponseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Tag(name = "find accounts", description = "계정 찾기 api")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/accounts")
public class FindAccountsController {

    private final FindAccountsService findAccountsService;
    private final ResponseService responseService;

    @ApiOperation(value = "아이디 찾기", notes = "아이디를 찾는다.")
    @GetMapping(value = "/find-id")
    public SingleResult findId(@RequestParam(value = "name") String name, @RequestParam(value = "email") String email) {
        //키, value 값으로 이루어진 해시맵을 이용.
        HashMap<String, String> userId = new HashMap<>();

        //서비스에서 이름과 이메일을 통해 아이디를 찾아오고. 그것을 userId의 userId에 반환받은 Id값을 넣음.
        userId.put("userId", findAccountsService.findIdDto(name, email));

        //안드로이드에 userId를 보냄.
        return responseService.getSingleResult(userId);
    }

    /* 비밀번호 찾기 */
    // 아이디, 이메일이 일치하는 user가 있는지 체크
    @ApiOperation(value = "비밀번호 찾기", notes = "비밀번호를 찾는다.")
    @PostMapping("/find-pw")
    public CommonResult findPw(@RequestBody UserDto.FindPwDto findPwDto) {

        findAccountsService.findPwDto(findPwDto.getUserId(), findPwDto.getEmail(), findPwDto.getUserName());

        return responseService.getSuccessResult();
    }
}
