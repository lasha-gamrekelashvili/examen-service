package com.example.examenservice.service.exam;

import com.example.examenservice.exception.AppException;
import com.example.examenservice.storage.document.ExamDocument;
import com.example.examenservice.storage.document.QuestionDocument;
import com.example.examenservice.storage.exam.ExamRepository;
import com.example.examenservice.storage.question.QuestionRepository;
import com.example.examenservice.web.dto.PushQuestionsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExamServiceImpl implements ExamService{
    private final ExamRepository examRepository;
    private final QuestionRepository questionRepository;

    @Override
    public ExamDocument save(ExamDocument examDocument) {
        return examRepository.save(examDocument);
    }

    @Override
    public List<ExamDocument> getAll() {
        List<ExamDocument> response = examRepository.findAll();

        for(ExamDocument examDocument : response){
            for(QuestionDocument questionDocument : examDocument.getQuestionDocuments()){
                questionDocument.setCorrectAnswer("");
            }
        }
        return response;
    }

    @Override
    public ExamDocument pushQuestions(PushQuestionsDto dto) {
        Optional<ExamDocument> examOptional = examRepository.findById(dto.getExamId());

        if(examOptional.isEmpty()){
            throw new AppException((String.format("Exam with ID: [%s] does not exist", dto.getExamId())), HttpStatus.UNPROCESSABLE_ENTITY);
        }

        ExamDocument examDocument = examOptional.get();

        List<QuestionDocument> questionsList = examDocument.getQuestionDocuments();
        List<String> questionIds = dto.getQuestionIds();

        questionsList.addAll(questionRepository.findAllById(questionIds));
        examDocument.setQuestionDocuments(questionsList);

        examRepository.save(examDocument);
        return examDocument;
    }
}
