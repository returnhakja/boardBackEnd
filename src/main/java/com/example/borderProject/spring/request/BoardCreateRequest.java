package com.example.borderProject.spring.request;

import lombok.Data;

@Data
public class BoardCreateRequest {
    private String title;
    private String content;
    private String writer;
}
