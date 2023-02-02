package com.example.examenservice.storage.document;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class QuestionDocument {

    @Id
    private String id;
    private String topic;
    private String text;
    private String answerOne;
    private String answerTwo;
    private String answerThree;
    private String answerFour;
    private String correctAnswer;
}
