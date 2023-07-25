package com.example.borderProject.spring.result;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardDeleteResult {
    private Object deleteInfo;
}
