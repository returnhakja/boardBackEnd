package com.example.borderProject.spring.result;

import com.example.borderProject.spring.dto.BoardDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BoardResult {
    private List<BoardDTO> borderList;
}
