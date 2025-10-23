package com.example.securesearch.controller;

import com.example.securesearch.model.SearchItem;
import com.example.securesearch.service.SearchService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/searchitem")
@CrossOrigin(origins = "*")
public class SearchItemController {

    private final SearchService service;

    public SearchItemController(SearchService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public SearchItem addItem(@RequestBody SearchItem item) {
        return service.save(item);
    }

    @GetMapping("/all")
    public List<SearchItem> getAllItems() {
        return service.getAll();
    }
}
