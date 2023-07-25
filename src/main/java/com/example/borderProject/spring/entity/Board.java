package com.example.borderProject.spring.entity;

import com.example.borderProject.spring.dto.BoardDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "board")
public class Board {
    @Id
    @Column(name = "board_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column(name = "title")
    private String title;


    @Column(name = "content")
    private String content;


    @Column(name = "board_time")
    private LocalDateTime createTime;

    @Column(name = "modified_date")
    @Setter
    private LocalDateTime updateTime;

    @Column(name = "useYn")
    @Setter
    private String useYn;

    @Column(name = "writer")
    @Setter
    private String writer;

    //== 생성 메서드 ==//
    public static Board createNote(String title, String content, String writer) {
        LocalDateTime now = LocalDateTime.now();

        return Board.builder()
                .title(title)
                .content(content)
                .createTime(now)
                .updateTime(null)
                .useYn("y")
                .writer(writer)
                .build();
    }


    public void updateCal(BoardDTO BoardDTO) {
        this.title = BoardDTO.getBoardTitle();
        this.content = BoardDTO.getContent();
        this.useYn = "y";
        this.updateTime = LocalDateTime.now();

    }
}
