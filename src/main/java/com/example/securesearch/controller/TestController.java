package com.example.demo.controller;

import com.example.demo.model.TestDocument;
import com.example.demo.repository.TestDocumentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

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
    @GetMapping("/all")
    public List<TestDocument> getAllDocuments() {
        return repository.findAll();
    }
}
