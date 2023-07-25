package com.example.borderProject.spring.result;

import com.example.borderProject.spring.dto.BoardDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardIdResult {
    private BoardDTO boardInfo;
}
