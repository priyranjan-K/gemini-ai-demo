package com.genai.example.gemini.service;

import com.google.genai.types.GenerateImagesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;


@Service
public class GeminiServiceImpl implements GeminiService {

    @Value("${GEMINI_TEXT_MODEL}")
    private String geminiTextModel;

    @Value("${GEMINI_IMAGE_MODEL}")
    private String geminiImageModel;

    private final Client geminiClient;

    @Autowired
    GeminiServiceImpl(Client geminiClient) {
        this.geminiClient = geminiClient;
    }
   

    @Override
    public ResponseEntity<String> askQuery(String query) {
        GenerateContentResponse response = geminiClient.models.
                generateContent(geminiTextModel, query, null);
        return ResponseEntity.ok(response.text());
    }

    @Override
    public ResponseEntity<String> generateImage(String query) {

        GenerateImagesResponse response = geminiClient.models.generateImages(geminiImageModel, query, null);
        return ResponseEntity.ok(response.generatedImages().get().get(0).image().get().gcsUri().get());
    }

}
