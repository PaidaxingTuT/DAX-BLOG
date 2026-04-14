package com.daxtech.daxblog.service.AI.Service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface OilPriceAiService {
    @SystemMessage(fromResource = "prompt/oilprice.txt")
    String getOilPrice(@UserMessage String userMessage);
}
