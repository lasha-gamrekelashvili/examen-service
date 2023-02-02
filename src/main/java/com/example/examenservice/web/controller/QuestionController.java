package com.example.examenservice.web.controller;

import com.example.examenservice.service.question.QuestionService;
import com.example.examenservice.storage.document.QuestionDocument;
import com.example.examenservice.storage.question.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping("")
    private ResponseEntity<Object> save(@RequestBody QuestionDocument questionDocument){
        return new ResponseEntity<>(questionService.save(questionDocument), HttpStatus.OK);
    }
}
