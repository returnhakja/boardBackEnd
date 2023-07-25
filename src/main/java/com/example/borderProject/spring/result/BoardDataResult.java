package com.example.borderProject.spring.result;

import com.example.borderProject.spring.entity.Board;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardDataResult {
    private Board boardData;
}
