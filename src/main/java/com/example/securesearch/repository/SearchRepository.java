package com.example.securesearch.repository;

import com.example.securesearch.model.SearchItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SearchRepository extends MongoRepository<SearchItem, String> {
}
