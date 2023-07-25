package com.example.borderProject.spring.controller;

import com.example.borderProject.spring.dto.BoardDTO;
import com.example.borderProject.spring.entity.Board;
import com.example.borderProject.spring.request.BoardCreateRequest;
import com.example.borderProject.spring.result.BoardDataResult;
import com.example.borderProject.spring.result.BoardIdResult;
import com.example.borderProject.spring.result.BoardResult;
import com.example.borderProject.spring.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
@CrossOrigin(origins = "*")
public class BoardContorller {

    private final BoardService boardService;


    //전체 조회
    @GetMapping
    public BoardResult findAll() {
        BoardResult result = boardService.findBoards();
        return result;
    }

    // 한개 조회
    @GetMapping(value = "/{boardId}")
    public BoardIdResult findByBoardId(@PathVariable(name = "boardId")int boardId){
        System.out.println(boardId);
        BoardIdResult result = boardService.findBoardId(boardId);
        System.out.println(result);
        return result;
    }

    //추가
    @PostMapping
    public BoardDataResult insert(@RequestBody @Validated BoardCreateRequest request) {
        Board createBoard = Board.createNote(request.getTitle(), request.getContent(), request.getWriter());
        BoardDataResult result = boardService.insertByBoard(createBoard);
        return result;
    }

    //삭제
    @PutMapping(value = "{boardId}")
    public void deleteByBoardId(@PathVariable(name = "boardId") int boardId){
        System.out.println(boardId);
        boardService.deleteBoard(boardId);
    }


    //수정
    @PutMapping
    public int updateCalByBoardId(@RequestBody @Validated BoardDTO requestDTO) {
        System.out.println(requestDTO);
        boardService.updateByBoard(requestDTO);
        return requestDTO.getBoardId();
    }
}
