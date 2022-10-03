package com.example.fitsum.Dto;

import com.example.fitsum.domain.Board;
import org.springframework.stereotype.Component;

@Component
public class BoardDtoConverter {
    public static BoardDto.ShowBoardDto toShowBoardDto(Board board, Boolean isMe) {
        return BoardDto.ShowBoardDto.builder()
                .boardId(board.getBoardId())
                .userId(board.getUser().getUserId())
                .content(board.getContent())
                .isMe(isMe)
                .build();
    }

    public static BoardDto.BoardViewDto toBoardViewDto(Board board, String loginId, Boolean liked) {
        return BoardDto.BoardViewDto.builder()
                .userId(board.getUser().getUserId())
                .loginId(loginId)
                .boardId(board.getBoardId())
                .nickName(board.getUser().getNickName())
                .content(board.getContent())
                .build();
    }

    public static BoardDto.BoardResultDto toDiaryResultDto(Board board) {
        return BoardDto.BoardResultDto.builder()
                .boardId(board.getBoardId())
                .userId(board.getUser().getUserId())
                .content(board.getContent())
                .build();
    }
}
