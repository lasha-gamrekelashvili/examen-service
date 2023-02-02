package com.example.examenservice.storage.question;

import com.example.examenservice.storage.document.QuestionDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepository extends MongoRepository<QuestionDocument,String> {

}
