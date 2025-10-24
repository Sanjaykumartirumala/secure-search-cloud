package com.example.securesearch.repository;

import com.example.securesearch.model.SearchItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends MongoRepository<SearchItem, String> {
}
