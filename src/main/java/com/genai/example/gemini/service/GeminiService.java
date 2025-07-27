package com.genai.example.gemini.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface GeminiService {

    ResponseEntity<String> askQuery(String query);
    ResponseEntity<String> generateImage(String query);

}
