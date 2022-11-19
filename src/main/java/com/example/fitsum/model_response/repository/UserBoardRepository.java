package com.example.fitsum.model_response.repository;

import com.example.fitsum.domain.Board;
import com.example.fitsum.domain.User;
import com.example.fitsum.domain.UserBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserBoardRepository extends JpaRepository<UserBoard, Long> {

    public Optional<List<UserBoard>> findAllByUser(User user);
    public boolean existsByUserAndBoard(User user, Board board);

    //추후 boardservice 에서 삭제할시 사용
//    public Optional<Void> deleteByUserAndBaord(User user, Board board);

}
