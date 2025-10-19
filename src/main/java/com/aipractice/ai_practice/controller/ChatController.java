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
    //this is a builder class whose bean you'll get
    //chatClient you cannot autowire as it's an interface
    public ChatController(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }

    @GetMapping("/chat")
    public ResponseEntity<String> chatOllama(
            @RequestParam(value = "ques", required = true) String ques
    ) {
        var aiResponse = chatClient.prompt(ques).call().content();
       return ResponseEntity.ok(aiResponse) ;
    }

}
