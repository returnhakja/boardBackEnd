package com.example.borderProject.spring.controller;

import com.example.borderProject.spring.dto.BoardDTO;
import com.example.borderProject.spring.entity.Board;
import com.example.borderProject.spring.request.BoardCreateRequest;
import com.example.borderProject.spring.result.BoardDataResult;
import com.example.borderProject.spring.result.BoardIdResult;
import com.example.borderProject.spring.result.BoardResult;
import com.example.borderProject.spring.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public BoardIdResult findByBoardId(@PathVariable(name = "boardId")Long boardId){
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
    public void deleteByBoardId(@PathVariable(name = "boardId") Long boardId){
        System.out.println(boardId);
        boardService.deleteBoard(boardId);
    }
    // 다중 삭제
    @PutMapping(value = "/delete")
    public List<Long> deleteBoards(@RequestBody List<Long> boardIdxArray){
        System.out.println(boardIdxArray);
        boardService.deleteBoards(boardIdxArray);
        return null;
    }

    //수정
    @PutMapping
    public Long updateCalByBoardId(@RequestBody @Validated BoardDTO requestDTO) {
        System.out.println(requestDTO);
        boardService.updateByBoard(requestDTO);
        return requestDTO.getBoardId();
    }
}
