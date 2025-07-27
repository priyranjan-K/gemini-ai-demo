package com.genai.example.gemini.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genai.example.gemini.service.GeminiService;

@RestController
@RequestMapping("/api/gemini")
public class GeminiController {
    
    private final GeminiService geminiService;

    GeminiController(GeminiService geminiService){
        this.geminiService=geminiService;
    }

    @PostMapping(value = "/ask", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> askGemini(@RequestBody(required = true) String query) {
        return geminiService.askQuery(query);
    }

    @PostMapping(value = "/image", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getImage(@RequestBody(required = true) String query) {
        return geminiService.generateImage(query);
    }

}
