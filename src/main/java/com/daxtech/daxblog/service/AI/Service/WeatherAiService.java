package com.daxtech.daxblog.service.AI.Service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface WeatherAiService {
    @SystemMessage(fromResource = "prompt/weather.txt")
    String getWeather(@UserMessage String userMessage);
}
