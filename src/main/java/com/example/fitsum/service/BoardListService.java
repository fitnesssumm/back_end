package com.example.fitsum.service;


import com.example.fitsum.Dto.BoardDto;
import com.example.fitsum.Dto.BoardDtoConverter;
import com.example.fitsum.domain.Board;
import com.example.fitsum.model_response.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardListService {
    private final BoardRepository boardRepository;
    @Transactional
    public List<BoardDto.BoardViewDto> getBoardList() {
//        if(user.getMyBoardList().size() == 0)
//            return null;

        log.info("log for jpa diary paging");

        List<Board> boardList = boardRepository.findAll();


        // db에서 받은 일기 미리보기 리스트를 dto로 변환하기 위한 리스트
        List<BoardDto.BoardViewDto> boardViewDtoList = new ArrayList<>();

        // dto리스트로 변환
        for (Board board : boardList) {
            boardViewDtoList.add(BoardDtoConverter.toBoardViewDto(board, false));
        }

        return boardViewDtoList;
    }

//    @Transactional
//    public List<BoardDto.BoardViewDto> getMyBoardListByUserId(String userId, Pageable pageable) {
//        // 서비스에서도 db에서 꺼내는 것 정도는 뭐...
//        User user = userRepository.findByUserId(userId).orElseThrow(CUserNotFoundException::new);
//
//        if(user.getMyBoardList().size() == 0)
//            return null;
//
//        log.info("log for jpa diary paging");
//        log.info(" " + user.getMyBoardList().get(0).getBoardId());
//
//        List<Board> boardList = boardRepository.findByUser(user, pageable).orElseThrow();
//
//        // db에서 받은 일기 미리보기 리스트를 dto로 변환하기 위한 리스트
//        List<BoardDto.BoardViewDto> boardViewDtoList = new ArrayList<>();
//
//        // dto리스트로 변환
//        for (Board board : boardList) {
//            boardViewDtoList.add(BoardDtoConverter.toBoardViewDto(board, userId, false));
//        }
//
//        return boardViewDtoList;
//    }

}
