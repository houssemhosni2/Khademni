package com.example.khademni.controllers;

import com.example.khademni.services.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private OpenAIService openAIService;

    @PostMapping("/send")
    public String sendMessage(@RequestBody Map<String, String> request) {
        String userMessage = request.get("message");
        return openAIService.getChatResponse(userMessage);
    }
}

