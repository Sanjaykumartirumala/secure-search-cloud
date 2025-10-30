<<<<<<< HEAD
package com.example.demo.controller;

import com.example.demo.model.TestDocument;
import com.example.demo.repository.TestDocumentRepository;
=======
package com.example.securesearch.controller;

import com.example.securesearch.model.TestDocument;
import com.example.securesearch.repository.TestDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> ff75c05 (Added mvnw.cmd and updated Dockerfile for Render deployment)
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

<<<<<<< HEAD
    private final TestDocumentRepository repository;

    public TestController(TestDocumentRepository repository) {
        this.repository = repository;
    }

    // Create a document
    @PostMapping("/create")
    public TestDocument createDocument(@RequestParam String message) {
        return repository.save(new TestDocument(message));
    }

    // Get all documents
=======
    @Autowired
    private TestDocumentRepository repository;

    // Create a new TestDocument
    @PostMapping("/add")
    public TestDocument addDocument(@RequestBody TestDocument doc) {
        return repository.save(doc);
    }

    // Get all TestDocuments
>>>>>>> ff75c05 (Added mvnw.cmd and updated Dockerfile for Render deployment)
    @GetMapping("/all")
    public List<TestDocument> getAllDocuments() {
        return repository.findAll();
    }
}
