package com.example.securesearch.service;

import com.example.securesearch.model.SearchItem;
import com.example.securesearch.repository.SearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    private final SearchRepository repository;

    public SearchService(SearchRepository repository) {
        this.repository = repository;
    }

    public SearchItem save(SearchItem item) {
        return repository.save(item);
    }

    public List<SearchItem> getAll() {
        return repository.findAll();
    }
}
