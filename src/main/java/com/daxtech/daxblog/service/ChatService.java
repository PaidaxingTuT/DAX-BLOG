package com.daxtech.daxblog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final AIService aiService;

    public String getMessage(String userMessage) {
        try{
            return aiService.chat(userMessage);
        } catch (Exception e){
            return "系统异常，请稍后再试~";
        }
    }
}
