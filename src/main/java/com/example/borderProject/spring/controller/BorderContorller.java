package com.example.borderProject.spring.controller;

import com.example.borderProject.spring.result.BoardResult;
import com.example.borderProject.spring.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class BorderContorller {

    private final BoardService boardService;


    @GetMapping(value = "/border")
    public BoardResult findAll() {
        System.out.println(">????>>>>>>");
        System.out.println("으앙");
        System.out.println("으앙3");
        BoardResult result = boardService.findBoards();
        System.out.println(result);
        return result;
    }
}
