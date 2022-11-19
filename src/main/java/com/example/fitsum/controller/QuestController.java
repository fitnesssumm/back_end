package com.example.fitsum.controller;

import com.example.fitsum.Dto.QuestDto;
import com.example.fitsum.model_response.SingleResult;
import com.example.fitsum.service.QuestService;
import com.example.fitsum.service.ResponseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "quest", description = "퀘스트 리스트 API")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class QuestController {

    private final QuestService questService;

    private  final ResponseService responseService;

    @GetMapping("/quest")
    @Operation(summary = "퀘스트 받아오기", description = "퀘스트 가져옴")
    public SingleResult qusetList(){
        List<QuestDto.ViewQuestDto> viewQuestDtoList = questService.getQusetList();

        return responseService.getSingleResult(viewQuestDtoList);
    }



}
