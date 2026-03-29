package com.daxtech.daxblog.config;

import com.daxtech.daxblog.service.AIService;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class commonConfig {

    private OpenAiChatModel model;

    @Bean
    public AIService aiService() {
        return AiServices.builder(AIService.class)
                .chatModel(model)
                .build();
    }

}
