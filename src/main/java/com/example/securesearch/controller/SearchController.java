package com.example.securesearch.controller;

import com.example.securesearch.model.EncryptedFile;
import com.example.securesearch.service.EncryptionService;
import com.example.securesearch.service.VerificationService;
import com.example.securesearch.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SearchController {

    @Autowired private EncryptionService encryptionService;
    @Autowired private VerificationService verificationService;
    @Autowired private FileRepository fileRepo;

    @PostMapping("/upload")
    public String uploadFile(@RequestBody EncryptedFile file) throws Exception {
        String encryptedText = encryptionService.encrypt(file.getEncryptedContent());
        Set<String> encryptedKeywords = encryptionService.generateEncryptedKeywords(file.getEncryptedContent());
        String verificationHash = verificationService.generateVerificationHash(encryptedText, encryptedKeywords);
        file.setEncryptedContent(encryptedText);
        file.setEncryptedKeywords(encryptedKeywords);
        file.setVerificationHash(verificationHash);
        fileRepo.save(file);
        return "✅ File securely uploaded with verification object.";
    }

    @PostMapping("/search")
    public List<EncryptedFile> search(@RequestParam String keyword) throws Exception {
        String hashKeyword = encryptionService.generateEncryptedKeywords(keyword).iterator().next();
        return fileRepo.findAll().stream()
                .filter(f -> f.getEncryptedKeywords().contains(hashKeyword))
                .collect(Collectors.toList());
    }

    @PostMapping("/verify/{id}")
    public String verifyFile(@PathVariable String id) throws Exception {
        EncryptedFile file = fileRepo.findById(id).orElse(null);
        if (file == null) return "❌ File not found.";

        String recalculatedHash = verificationService.generateVerificationHash(
                file.getEncryptedContent(), file.getEncryptedKeywords());

        if (verificationService.verifyHash(file.getVerificationHash(), recalculatedHash))
            return "✅ Verification Successful — Data not tampered.";
        else
            return "⚠️ Verification Failed — Data may be incomplete or modified.";
    }
}
