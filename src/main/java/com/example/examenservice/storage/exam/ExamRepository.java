package com.example.examenservice.storage.exam;

import com.example.examenservice.storage.document.ExamDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExamRepository extends MongoRepository<ExamDocument,String> {
}
