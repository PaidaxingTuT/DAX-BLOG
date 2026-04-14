package com.daxtech.daxblog.service.AI.Service;

import com.daxtech.daxblog.response.BanWordResponse;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface BanWordAiService {
    @SystemMessage(fromResource = "prompt/banword.txt")
    BanWordResponse banWord(@UserMessage String userMessage);
}
