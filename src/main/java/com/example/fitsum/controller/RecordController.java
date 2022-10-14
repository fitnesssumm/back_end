package com.example.fitsum.controller;

import com.example.fitsum.Dto.RecordDto;
import com.example.fitsum.exception.exceptions.CAuthenticationException;
import com.example.fitsum.model_response.CommonResult;
import com.example.fitsum.model_response.SingleResult;
import com.example.fitsum.service.RecordService;
import com.example.fitsum.service.ResponseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Tag(name = "record post", description = "운동 기록 API")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")

public class RecordController {

    final private RecordService recordService;

    final private ResponseService responseService;

    @PostMapping("/record")
    @Operation(summary = "운동기록 등록", description = "운동 기록을 등록합니다.")
    public CommonResult createRecord(@RequestBody RecordDto.CreateRecordDto createRecordDto) {
        //권한을 통해 유저 id를 획득합니다.
        String userId;

        try {
            //권한을 통해 유저 id를 획득합니다.
            userId = SecurityContextHolder.getContext().getAuthentication().getName();
        } catch (NullPointerException e) {
            log.info("Not legal authentication.");
            throw new CAuthenticationException();
        }
        recordService.saveRecord(userId, createRecordDto);

        return responseService.getSuccessResult();
    }
}