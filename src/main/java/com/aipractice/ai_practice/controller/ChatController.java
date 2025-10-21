package com.aipractice.ai_practice.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ChatController {

    private ChatClient openAiChatClient;
    private ChatClient ollamaChatClient;

    //u can directly inject separate chat models. as of spring.ai v1.0.3 these both classes are not available
    public ChatController(OpenAiChatModel openAiChatModel, OllamaChatModel ollamaChatModel){
        System.out.println(openAiChatModel.getClass().getName());
        System.out.println(ollamaChatModel.getClass().getName());

        //since u turned off the chatclient builder in properties you can fine control here
        this.openAiChatClient=ChatClient.builder(openAiChatModel).build();
        this.ollamaChatClient=ChatClient.builder(ollamaChatModel).build();
    }

    @GetMapping("/chat")
    public ResponseEntity<String> chatOllama(
            @RequestParam(value = "ques", required = true) String ques
    ) {
        var aiResponse = this.openAiChatClient
                .prompt(ques)
                .call()
                .content();
       return ResponseEntity.ok(aiResponse) ;
    }

}
