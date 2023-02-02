package com.example.examenservice.service.exam;

import com.example.examenservice.storage.document.ExamDocument;
import com.example.examenservice.web.dto.PushQuestionsDto;

import java.util.List;

public interface ExamService {
    ExamDocument save(ExamDocument examDocument);
    List<ExamDocument> getAll();
    ExamDocument pushQuestions(PushQuestionsDto dto);
}
