package com.example.fitsum.controller;

import com.example.fitsum.Dto.BoardDto;
import com.example.fitsum.model_response.SingleResult;
import com.example.fitsum.service.BoardListService;
import com.example.fitsum.service.ResponseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@Tag(name = "get board list", description = "게시판 출력 API")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board-list")
public class ShowBoardListController {

    private final BoardListService boardListService;
    private final ResponseService responseService;

//    @GetMapping("/mine")
//    @Operation(summary = "나의 일기장 리스트", description = "내가 작성한 일기 리스트의 정보를 가져옴.")
//    public SingleResult showMyDiaryList(@PageableDefault(size = 10) Pageable pageable) {
//        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
//
//        // 사용자 인증 후 꺼내오기(pagable이 페이지 단위로 불러오기는 효과적)
//        List<BoardDto.BoardViewDto> boardViewDtoList = BoardListService.getBoardList(pageable);
//
//        return responseService.getSingleResult(boardViewDtoList);
//    }

    @GetMapping("/everyone")
    @Operation(summary = "게시판 리스트", description = "게시판 리스트를 가져옴")
    public SingleResult showMyDiaryList(@PageableDefault(size = 10) Pageable pageable) {

        List<BoardDto.BoardViewDto> boardViewDtoList = boardListService.getBoardList();

        return responseService.getSingleResult(boardViewDtoList);
    }


}
