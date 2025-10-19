package com.example.securesearch.service;

import org.springframework.stereotype.Service;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.*;
import java.util.Base64;

@Service
public class EncryptionService {
    private static final String SECRET_KEY = "cloudsecurekey123";

    public String encrypt(String text) throws Exception {
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.getEncoder().encodeToString(cipher.doFinal(text.getBytes()));
    }

    public String decrypt(String encrypted) throws Exception {
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64.getDecoder().decode(encrypted)));
    }

    public Set<String> generateEncryptedKeywords(String content) throws Exception {
        String[] words = content.toLowerCase().split("\\W+");
        Set<String> tokens = new HashSet<>();
        for (String word : words) {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest((word + SECRET_KEY).getBytes());
            tokens.add(Base64.getEncoder().encodeToString(hash));
        }
        return tokens;
    }
}
