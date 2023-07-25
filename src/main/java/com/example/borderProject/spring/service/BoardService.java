package com.example.borderProject.spring.service;

import com.example.borderProject.spring.dto.BoardDTO;
import com.example.borderProject.spring.entity.Board;
import com.example.borderProject.spring.repository.BoardRepository;
import com.example.borderProject.spring.result.BoardDataResult;
import com.example.borderProject.spring.result.BoardIdResult;
import com.example.borderProject.spring.result.BoardResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardResult findBoards() {
        List<Board> boardEntityList = boardRepository.findAll();
        List<BoardDTO> boardDtoList = boardEntityList.stream()
                .filter(board -> board.getUseYn().equalsIgnoreCase("y"))
                .map(BoardDTO::new)
                .collect(Collectors.toList());
        BoardResult result = BoardResult.builder()
                .borderList(boardDtoList)
                .build();

        return result;
    }

    public BoardIdResult findBoardId(int boardId) {

        Board boardEntity = boardRepository.findByBoardId(boardId);
        BoardDTO boardInfo = new BoardDTO(boardEntity);
        BoardIdResult result = BoardIdResult.builder()
                .boardInfo(boardInfo)
                .build();
        return result;
    }

    @Transactional
    public BoardDataResult insertByBoard(Board board){
        System.out.println(board);
        Board saveBoard = boardRepository.save(board);
        BoardDataResult result = BoardDataResult.builder()
                .boardData(saveBoard)
                .build();
                return result;
    }

    @Transactional
    public void deleteBoard(int BoardId){
        Board boardEntity = boardRepository.findByBoardId(BoardId);
        boardEntity.setUseYn("n");
        boardEntity.setUpdateTime(LocalDateTime.now());
        System.out.println(boardEntity);
    }

    @Transactional
    public int updateByBoard(BoardDTO requestDTO){
        Board board = boardRepository.findByBoardId(requestDTO.getBoardId());
        board.updateCal(requestDTO);
        return requestDTO.getBoardId();
    }
}
