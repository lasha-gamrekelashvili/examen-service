package com.example.examenservice.web.controller;

import com.example.examenservice.service.exam.ExamService;
import com.example.examenservice.storage.document.ExamDocument;
import com.example.examenservice.storage.exam.ExamRepository;
import com.example.examenservice.web.dto.PushQuestionsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exam")
@RequiredArgsConstructor
public class ExamController {
    private final ExamService examService;

    @PostMapping("")
    private ResponseEntity<Object> save(@RequestBody ExamDocument examDocument){
        return new ResponseEntity<>(examService.save(examDocument), HttpStatus.OK);
    }

    @GetMapping("/all")
    private ResponseEntity<Object> getAll(){
        return new ResponseEntity<>(examService.getAll(),HttpStatus.OK);
    }

    @PostMapping("/add-question")
    private ResponseEntity<Object> PushQuestions(@RequestBody PushQuestionsDto request){
            ExamDocument examDocument = examService.pushQuestions(request);
            return new ResponseEntity<>(examDocument,HttpStatus.OK);
    }
}
