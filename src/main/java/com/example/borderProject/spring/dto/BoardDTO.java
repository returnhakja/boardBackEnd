package com.example.borderProject.spring.dto;

import com.example.borderProject.spring.entity.Board;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private Long boardId;
    private String boardTitle;

    private String boardWriter;
    private String content;

    private String useYn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime boardCreateTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime boardUpdateTime;

public BoardDTO(Board Board){
    this.boardId = Board.getBoardId();
    this.boardTitle = Board.getTitle();
    this.boardWriter = Board.getWriter();
    this.content = Board.getContent();
    this.useYn = Board.getUseYn();
    this.boardCreateTime = Board.getCreateTime();
    this.boardUpdateTime = Board.getUpdateTime();
}

}


