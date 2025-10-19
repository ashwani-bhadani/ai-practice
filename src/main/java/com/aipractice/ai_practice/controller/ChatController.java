package com.aipractice.ai_practice.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ChatController {

    private ChatClient chatClient;
    //this is a builder class who's bean u'll get

    public ChatController(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }

    @GetMapping("/chat")
    public ResponseEntity<String> chatOpenAI(
            @RequestParam(value = "ques", required = true) String ques
    ) {
        var aiResponse = chatClient.prompt(ques).call().content();
       return ResponseEntity.ok(aiResponse) ;
    }

}
