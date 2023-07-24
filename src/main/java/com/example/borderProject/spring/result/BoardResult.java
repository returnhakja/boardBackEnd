package com.example.borderProject.spring.result;

import com.example.borderProject.spring.dto.BorderDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BoardResult {
    private List<BorderDTO> borderList;
}
