package com.example.examenservice.storage.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@Document
public class ExamDocument {

    @Id
    private String id;
    private String name;

    @DocumentReference
    private List<QuestionDocument> questionDocuments;
}
