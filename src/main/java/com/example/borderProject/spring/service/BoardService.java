package com.example.borderProject.spring.service;

import com.example.borderProject.spring.dto.BorderDTO;
import com.example.borderProject.spring.entity.Border;
import com.example.borderProject.spring.repository.BoardRepository;
import com.example.borderProject.spring.result.BoardResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardResult findBoards() {
        List<Border> boardEntityList = boardRepository.findAll();
        System.out.println("????");
        List<BorderDTO> boardDtoList = boardEntityList.stream()
                .map(o -> new BorderDTO(o))
                .collect(Collectors.toList());
        BoardResult result = BoardResult.builder()
                .borderList(boardDtoList)
                .build();

        return result;
    }
}
