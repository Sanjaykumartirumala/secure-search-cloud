package com.example.securesearch.service;

import org.springframework.stereotype.Service;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Set;

@Service
public class VerificationService {

    public String generateVerificationHash(String encryptedContent, Set<String> encryptedKeywords) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        String combined = encryptedContent + String.join("", encryptedKeywords);
        byte[] hash = digest.digest(combined.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }

    public boolean verifyHash(String storedHash, String recalculatedHash) {
        return storedHash.equals(recalculatedHash);
    }
}
