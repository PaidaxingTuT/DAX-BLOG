package com.daxtech.daxblog.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;


public interface AIService {

    @SystemMessage(fromResource = "prompt.txt")
    String chat(@UserMessage String userMessage);
}


