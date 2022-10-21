package com.example.fitsum.controller;

import com.example.fitsum.Dto.BoardDto;
import com.example.fitsum.exception.exceptions.CAuthenticationException;
import com.example.fitsum.exception.exceptions.CWrongBoardIdException;
import com.example.fitsum.model_response.CommonResult;
import com.example.fitsum.model_response.SingleResult;
import com.example.fitsum.service.BoardService;
import com.example.fitsum.service.ResponseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Tag(name = "diary post", description = "일기 작업 API")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardController {

    final private BoardService boardService;
    final private ResponseService responseService;

    @GetMapping("/board/{board-id}")
    @Operation(summary = "나의 일기장 리스트", description = "내가 작성한 일기 정보를 가져옴.")
    public SingleResult showBoard(@PathVariable("board-id") String boardIds) {
        Long boardId;
        BoardDto.ShowBoardDto boardDto;

        log.info(boardIds + "");

        try {
            boardId = Long.parseLong(boardIds);
            //일기장을 showdto로 보여지는 용도로만 사용
            boardDto = boardService.getBoardByboardId(boardId);
        } catch (CWrongBoardIdException e) {
            throw new CWrongBoardIdException();
        }
        return responseService.getSingleResult(boardDto);
    }

    @PostMapping("/board")
    @Operation(summary = "일기 등록", description = "제목(title)과 내용(content)을 이용하여 일기를 신규 등록합니다.")
    public CommonResult createBoard(@RequestBody BoardDto.CreateBoardDto createBoardDto) {
        //권한을 통해 유저 id를 획득합니다.
        String userId;

        try {
            //권한을 통해 유저 id를 획득합니다. -> userId에 넣음
            userId = SecurityContextHolder.getContext().getAuthentication().getName();
        } catch (NullPointerException e) {
            log.info("Not legal authentication.");
            throw new CAuthenticationException();
        }

        //해당 userId와 createBoard를 서비스로 넘김.
        boardService.saveBoard(userId, createBoardDto);

        //안드로이드에는 성공 응답을 보내줌.
        return responseService.getSuccessResult();
    }

//    @PutMapping("/board/{board-id}")
    //    @PutMapping("/board/{board-id}")
//    @Operation(summary = "일기 수정", description = "일기의 내용을 수정합니다. 제목 수정은 안됩니다.")
//    public SingleResult updateDiary(@RequestBody DiaryDto.UpdateDiaryDto updateDiaryDto, @PathVariable("diary-id") String boardIds) {
//        Long boardId;
//        DiaryDto.DiaryResultDto diaryResultDto;
//
//        log.info(boardIds + "");
//
//        try {
//            boardId = Long.parseLong(boardIds);
//            //일기장을 showdto로 보여지는 용도로만 사용
//            diaryResultDto = diaryService.updateContentAndOpenByboardId(updateDiaryDto, boardId);
//        } catch (CWrongboardIdException e) {
//            throw new CWrongboardIdException();
//        }
//        return responseService.getSingleResult(diaryResultDto);
//    }

//    @DeleteMapping("/board/{board-id}")
//    @Operation(summary = "일기 삭제", description = "일기를 삭제합니다.")
//    public SingleResult deleteDiary(@PathVariable("diary-id") Long boardId) {
//        return responseService.getSingleResult(diaryService.deleteByboardId(boardId));
//    }
//
//    @PostMapping("/board/like")
//    @Operation(summary = "일기 좋아요", description = "일기를 좋아요/좋아요 취소 입력.")
//    public CommonResult updateLike(@RequestParam(value = "like")Boolean liked, @RequestParam(value = "boardId") String boardIds){
//        String loginId = SecurityContextHolder.getContext().getAuthentication().getName();
//        Long boardId = Long.parseLong(boardIds);
//
//        log.info(liked+"");
//
//        diaryService.updateLike(loginId, boardId, liked);
//
//        return responseService.getSuccessResult();
//    }
}