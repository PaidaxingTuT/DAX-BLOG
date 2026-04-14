package com.daxtech.daxblog.config;

import com.daxtech.daxblog.service.AI.Service.*;
import com.daxtech.daxblog.utils.OilPriceUtil;
import com.daxtech.daxblog.utils.WeatherUtil;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CommonConfig {

    private final OpenAiChatModel model;

    @Bean
    public ChatAiService chatService(WeatherUtil weatherUtil, OilPriceUtil oilPriceUtil) {
        return AiServices.builder(ChatAiService.class)
                .chatModel(model)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .tools(weatherUtil,oilPriceUtil)
                .build();
    }

    @Bean
    public WeatherAiService weatherService(WeatherUtil weatherUtil) {
        return AiServices.builder(WeatherAiService.class)
                .chatModel(model)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(5))
                .tools(weatherUtil)
                .build();
    }

    @Bean
    public OilPriceAiService oilPriceAiService(OilPriceUtil oilPriceUtil) {
        return AiServices.builder(OilPriceAiService.class)
                .chatModel(model)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(5))
                .tools(oilPriceUtil)
                .build();
    }

    @Bean
    public BanWordAiService banWordService() {
        return AiServices.builder(BanWordAiService.class)
                .chatModel(model)
                .build();
    }

    @Bean
    public StateAiService stateService() {
        return AiServices.builder(StateAiService.class)
                .chatModel(model)
                .build();
    }
}
