package com.example.securesearch.repository;

import com.example.securesearch.model.TestDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDocumentRepository extends MongoRepository<TestDocument, String> {
    // Optional: add custom query methods if needed
}
