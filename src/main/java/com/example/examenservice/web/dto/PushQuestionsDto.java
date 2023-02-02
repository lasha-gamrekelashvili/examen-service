package com.example.examenservice.web.dto;

import lombok.Data;

import java.util.List;

@Data
public class PushQuestionsDto {
    private String examId;
    private List<String> questionIds;
}
