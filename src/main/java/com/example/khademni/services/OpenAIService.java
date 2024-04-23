package com.example.khademni.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class OpenAIService {

    @Value("${openai.api.key}")
    private String openaiApiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    @Retryable(value = {HttpClientErrorException.TooManyRequests.class}, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    public String getChatResponse(String userMessage) {
        String apiUrl = "https://api.openai.com/v1/chat/completions";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + openaiApiKey);

        // Prepare request body
        Map<String, Object> requestBody = Map.of(
                "model", "gpt-3.5-turbo",
                "messages", List.of(Map.of("role", "user", "content", userMessage))
        );

        // Make the API call
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<Map> response = restTemplate.postForEntity(apiUrl, entity, Map.class);

        // Handle response
        Map<?, ?> responseBody = response.getBody(); // Use wildcard to avoid type issues
        if (responseBody != null && responseBody.containsKey("choices")) {
            List<Map<?, ?>> choices = (List<Map<?, ?>>) responseBody.get("choices");
            if (!choices.isEmpty()) {
                Map<?, ?> firstChoice = choices.get(0); // Access the first choice
                Map<?, ?> message = (Map<?, ?>) firstChoice.get("message");
                if (message != null && message.containsKey("content")) {
                    return message.get("content").toString(); // Retrieve the content
                }
            }
        }

        return "Sorry, I couldn't get a response from OpenAI.";
    }
}
