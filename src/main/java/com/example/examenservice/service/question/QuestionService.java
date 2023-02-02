package com.example.examenservice.service.question;

import com.example.examenservice.storage.document.QuestionDocument;

public interface QuestionService {
    QuestionDocument save(QuestionDocument questionDocument);
}
