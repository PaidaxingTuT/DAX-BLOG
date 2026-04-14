package com.daxtech.daxblog.service.AI.Business;

import com.daxtech.daxblog.enums.ResultCodeEnum;
import com.daxtech.daxblog.response.Response;
import com.daxtech.daxblog.service.AI.Service.WeatherAiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class WeatherBusinessService {

    private final WeatherAiService weatherService;

    private final EdgeTTSServiceImp edgeTTSServiceImp;


    public String getWeather(String userMessage) {
        log.info("天气>>>大模型获取的消息为: {}", userMessage);
        try {
            String textResponse = weatherService.getWeather(userMessage);
            log.info("天气播报文字回复: {}", textResponse);

            //return edgeTTSServiceImp.tts(textResponse);
            return textResponse;

        } catch (Exception e) {
            log.error("天气服务处理异常: ", e);
            return Response.faildata(ResultCodeEnum.SERVER_ERROR, "服务异常").toString();

        }
    }
}
