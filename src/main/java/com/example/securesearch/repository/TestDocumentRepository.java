<<<<<<< HEAD
package com.example.demo.repository;

import com.example.demo.model.TestDocument;
=======
package com.example.securesearch.repository;

import com.example.securesearch.model.TestDocument;
>>>>>>> ff75c05 (Added mvnw.cmd and updated Dockerfile for Render deployment)
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<< HEAD
public interface TestDocumentRepository extends MongoRepository<TestDocument, String> {}
=======
public interface TestDocumentRepository extends MongoRepository<TestDocument, String> {
    // Optional: add custom query methods if needed
}
>>>>>>> ff75c05 (Added mvnw.cmd and updated Dockerfile for Render deployment)
