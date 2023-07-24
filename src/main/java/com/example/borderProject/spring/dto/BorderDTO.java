package com.example.borderProject.spring.dto;

import com.example.borderProject.spring.entity.Border;
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
public class BorderDTO {
    private Long borderId;
    private String borderTitle;

    private String borderWriter;
    private String content;

    private String useYn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime boardCreateTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime boardUpdateTime;

public BorderDTO(Border border){
    this.borderId = border.getBoardId();
    this.borderTitle = border.getTitle();
    this.borderWriter = border.getWriter();
    this.content = border.getContent();
    this.useYn = border.getUseYn();
    this.boardCreateTime = border.getCreateTime();
    this.boardUpdateTime = border.getUpdateTime();
}

}


