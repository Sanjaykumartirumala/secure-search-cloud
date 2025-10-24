package com.example.securesearch.repository;

import com.example.securesearch.model.EncryptedFile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends MongoRepository<EncryptedFile, String> {}
