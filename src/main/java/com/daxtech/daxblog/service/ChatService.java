package com.daxtech.daxblog.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatService {

    private final AIService aiService;

    public String getMessage(String userMessage) {
        log.info("收到用户提问: {}", userMessage);

        try {
            String response = aiService.chat(userMessage);

            log.info("AI 回复内容: {}", response);

            return response;
        } catch (Exception e){
            log.error("调用大模型服务发生异常: ", e);
            return "系统异常，请稍后再试~";
        }
    }
}