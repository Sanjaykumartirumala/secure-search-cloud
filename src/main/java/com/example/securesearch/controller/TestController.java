package com.example.securesearch.controller;

import com.example.securesearch.model.TestDocument;
import com.example.securesearch.repository.TestDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestDocumentRepository repository;

    // Create a new TestDocument
    @PostMapping("/add")
    public TestDocument addDocument(@RequestBody TestDocument doc) {
        return repository.save(doc);
    }

    // Get all TestDocuments
    @GetMapping("/all")
    public List<TestDocument> getAllDocuments() {
        return repository.findAll();
    }
}
