package com.example.securesearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.securesearch.model.SecureFile;
import com.example.securesearch.repository.SecureFileRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SecureSearchController {

    @Autowired
    private SecureFileRepository repository;

    // Upload text
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("text") String text) {
        SecureFile file = new SecureFile();
        file.setContent(text);
        repository.save(file);
        return ResponseEntity.ok("File uploaded successfully!");
    }

    // Search for a keyword
    @GetMapping("/search")
    public ResponseEntity<List<String>> searchKeyword(@RequestParam("keyword") String keyword) {
        List<String> matched = repository.findAll().stream()
                .map(SecureFile::getContent)
                .filter(content -> content.contains(keyword))
                .collect(Collectors.toList());
        return ResponseEntity.ok(matched);
    }

    // Verify if keyword exists
    @GetMapping("/verify")
    public ResponseEntity<String> verifyFile(@RequestParam("keyword") String keyword) {
        boolean exists = repository.findAll().stream()
                .anyMatch(f -> f.getContent().contains(keyword));
        return ResponseEntity.ok(exists ? "Keyword found ✅" : "Keyword not found ❌");
    }

}
}
