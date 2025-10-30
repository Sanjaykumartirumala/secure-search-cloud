package com.example.securesearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {

    @GetMapping("/")
    public String home() {
        return "index"; // points to src/main/resources/templates/index.html
    }
}
