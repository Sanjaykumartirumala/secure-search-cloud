package com.example.securesearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Set;

@Document(collection = "encrypted_files")
public class EncryptedFile {
    @Id
    private String id;
    private String fileName;
    private String encryptedContent;
    private Set<String> encryptedKeywords;
    private String verificationHash;

    public String getId() { return id; }
    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }
    public String getEncryptedContent() { return encryptedContent; }
    public void setEncryptedContent(String encryptedContent) { this.encryptedContent = encryptedContent; }
    public Set<String> getEncryptedKeywords() { return encryptedKeywords; }
    public void setEncryptedKeywords(Set<String> encryptedKeywords) { this.encryptedKeywords = encryptedKeywords; }
    public String getVerificationHash() { return verificationHash; }
    public void setVerificationHash(String verificationHash) { this.verificationHash = verificationHash; }
}
