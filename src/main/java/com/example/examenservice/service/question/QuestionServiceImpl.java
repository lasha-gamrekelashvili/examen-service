package com.example.examenservice.service.question;

import com.example.examenservice.storage.document.QuestionDocument;
import com.example.examenservice.storage.question.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService{
    private final QuestionRepository questionRepository;

    @Override
    public QuestionDocument save(QuestionDocument questionDocument) {
        return questionRepository.save(questionDocument);
    }
}
