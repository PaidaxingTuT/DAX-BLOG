package com.daxtech.daxblog.service.AI.Service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface ChatAiService {

    @SystemMessage(fromResource = "prompt/daxai.txt")
    String chat(@UserMessage String userMessage,@V("currentCity") String currentCity);

}


