package com.example.borderProject.spring.repository;

import com.example.borderProject.spring.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    public List<Board> findAll();

    public Board findByBoardId(int boardId);

    public Board deleteByBoardId(Board board);
}
