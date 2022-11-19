package com.example.fitsum.service;

import com.example.fitsum.Dto.BoardDto;
import com.example.fitsum.Dto.BoardDtoConverter;
import com.example.fitsum.domain.Board;
import com.example.fitsum.domain.User;
import com.example.fitsum.exception.exceptions.CBoardNotFoundException;
import com.example.fitsum.exception.exceptions.CUserNotFoundException;
import com.example.fitsum.model_response.repository.BoardRepository;
import com.example.fitsum.model_response.repository.UserBoardRepository;
import com.example.fitsum.model_response.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardService {

    final private BoardRepository boardRepository;
    final private UserRepository userRepository;
    private final BoardDtoConverter boardDtoConverter;
    private final UserBoardRepository userBoardRepository;

    // 통신을 하기 위한.
    private RestTemplate restTemplate;
    @Transactional
    public BoardDto.ShowBoardDto getBoardByboardId(Long boardId){
        //게시판 엔티티 가져오기
        Board board = boardRepository.findByBoardId(boardId).orElseThrow(CBoardNotFoundException::new);

        //checkUser에서 본인인지 아닌지를 판별합니다. 본인일 경우 편집 버튼을 활성화 해서 updateBoard로 이동이 가능해집니다.
        return boardDtoConverter.toShowBoardDto(board, board.checkUser(true));
    }

    @Transactional
    public void saveBoard(String userId, BoardDto.CreateBoardDto createBoardDto) {

        //넘어온 userId로 유저정보를 user에 저장.
        User user = userRepository.findByUserId(userId).orElseThrow(CUserNotFoundException::new);

        //게시판에 저장
        Board board = boardRepository.save(
                Board.builder()
                        .user(user)
                        .content(createBoardDto.getContent())
                        .title(createBoardDto.getTitle())
                        .writeDate(LocalDate.now())
                        .build()
        );

//        @Transactional
//        public BoardDto.BoardResultDto updateContentAndOpenByboardId(BoardDto.UpdateBoardDto updateBoardDto, Long boardId) {
//            //수정할 일기장 불러오기
//            Board Board = BoardRepository.findById(boardId).orElseThrow(CBoardNotFoundException::new);
//
//            //일기의 유저와 로그인한 유저의 정보가 같은지 비교
//            Board.checkUser();
//            //엔티티에 업데이트할 값들
//            Board.update(updateBoardDto.getContent(), updateBoardDto.getOpen());
//
//            return BoardDtoConverter.toBoardResultDto(Board);
//        }

//    @Transactional
//    public BoardDto.BoardResultDto deleteByboardId(Long boardId){
//        Board Board = BoardRepository.findByboardId(boardId).orElseThrow(CBoardNotFoundException::new);
//
//        Board.checkUser();                                                                          //일기의 유저와 로그인한 유저의 정보가 같은지 비교
//
//        BoardRepository.deleteByboardId(boardId).orElseThrow(CBoardNotFoundException::new);
//        return BoardDtoConverter.toBoardResultDto(Board);
//    }
//
//    @Transactional
//    public void updateLike(String loginId, Long boardId, Boolean liked){
//        User user = userRepository.findByUserId(loginId).orElseThrow(CUserNotFoundException::new);
//        Board Board = BoardRepository.findByboardId(boardId).orElseThrow(CBoardNotFoundException::new);
//
//        if (liked){
//            userBoardRepository.save(UserBoard.builder()
//                    .Board(Board)
//                    .user(user)
//                    .build()
//            );
//        }else{
//            userBoardRepository.deleteByUserAndBoard(user, Board);
//        }
//    }
    }
}