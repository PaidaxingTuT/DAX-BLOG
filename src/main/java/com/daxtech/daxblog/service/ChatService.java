package com.daxtech.daxblog.service;

import dev.langchain4j.service.UserMessage;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ChatService {

    private final AIService aiService;

    public String getMessage(@UserMessage String userMessage) {
        try{
            return aiService.chat(userMessage);
        } catch (Exception e){
            return "系统异常，请稍后再试~";
        }
    }
}
