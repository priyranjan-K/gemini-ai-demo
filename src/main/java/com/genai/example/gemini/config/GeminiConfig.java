package com.genai.example.gemini.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.genai.Client;

@Configuration
public class GeminiConfig {

    @Value("${GEMINI_API_KEY}")
    private String geminiApiKey;

    @Value("${GEMINI_PROJECT_NAME}")
    private String geminiProjectName;

    @Bean
    public Client getClient() {
        return Client.builder().apiKey(geminiApiKey)
               .build();
    }

}
