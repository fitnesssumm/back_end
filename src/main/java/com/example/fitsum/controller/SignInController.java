package com.example.fitsum.controller;

import com.example.fitsum.config.security.JwtTokenProvider;
import com.example.fitsum.exception.exceptions.CUserNotFoundException;
import com.example.fitsum.model_response.CommonResult;
import com.example.fitsum.service.LogInService;
import com.example.fitsum.service.ResponseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Tag(name = "normal signin", description = "일반 로그인 api")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SignInController {

    private final LogInService logInService;
    private final ResponseService responseService;
    private final JwtTokenProvider jwtTokenProvider;

     @ApiOperation(value = "자동 로그인", notes = "자동 로그인을 한다.")
     @GetMapping(value = "/auto-login")
     public CommonResult autoLogin(HttpServletRequest request) {
     if ((jwtTokenProvider.resolveAccessToken(request) == null)
     && (jwtTokenProvider.resolveRefreshToken(request) == null))
     throw new CUserNotFoundException();
     else if
     (!jwtTokenProvider.validateToken(jwtTokenProvider.resolveRefreshToken(request)))
     throw new CUserNotFoundException();
     return responseService.getSuccessResult();

     }

    @ApiOperation(value = "로그인", notes = "회원 로그인을 한다.")
    @GetMapping(value = "/signin")
    public CommonResult signin(@RequestParam(value = "id") String id, @RequestParam(value = "password") String password, HttpServletResponse response) {
        log.info("여긴가요?");
        logInService.signInByLoginDto(id, password, response);
        return responseService.getSuccessResult();
    }
}
