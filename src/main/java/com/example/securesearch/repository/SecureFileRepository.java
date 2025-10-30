package com.example.securesearch.repository;

import com.example.securesearch.model.SecureFile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SecureFileRepository extends MongoRepository<SecureFile, String> { }
