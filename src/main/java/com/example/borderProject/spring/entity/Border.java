package com.example.borderProject.spring.entity;

import com.example.borderProject.spring.dto.BorderDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "board")
public class Border {
    @Id
    @Column(name = "board_id")
    @GeneratedValue
    private Long boardId;

    @Column(name = "title")
    private String title;


    @Column(name = "content")
    private String content;


    @Column(name = "board_time")
    private LocalDateTime createTime;

    @Column(name = "modified_date")
    private LocalDateTime updateTime;

    @Column(name = "useYn")
    private String useYn;

    @Column(name = "writer")
    @Setter
    private String writer;

    //== 생성 메서드 ==//
    public static Border createNote(String title, String content, String writer) {
        LocalDateTime now = LocalDateTime.now();

        return Border.builder()
                .title(title)
                .content(content)
                .createTime(now)
                .updateTime(null)
                .useYn("Y")
                .writer(writer)
                .build();
    }


    public void updateCal(BorderDTO borderDTO) {
        this.title = borderDTO.getBorderTitle();
        this.content = borderDTO.getContent();
        this.updateTime = LocalDateTime.now();

    }
}
