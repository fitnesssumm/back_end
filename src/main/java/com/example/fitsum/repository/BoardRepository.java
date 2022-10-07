package com.example.fitsum.repository;

import com.example.fitsum.domain.Board;
import com.example.fitsum.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {

    public Optional<Board> findByBoardId(Long boardId);
//    public Optional<List<Board>> findAll();

    public Optional<Boolean> deleteByBoardId(Long boardId);
}
