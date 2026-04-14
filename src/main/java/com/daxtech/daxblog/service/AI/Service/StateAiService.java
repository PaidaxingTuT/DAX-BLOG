package com.daxtech.daxblog.service.AI.Service;

import com.daxtech.daxblog.enums.StateEnum;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface StateAiService {
    @SystemMessage(fromResource = "prompt/state.txt")
    StateEnum getState(@UserMessage String userMessage);
}
