package com.daxtech.daxblog.State.Handler;

import com.daxtech.daxblog.State.MessageStateHandle;
import com.daxtech.daxblog.enums.ResultCodeEnum;
import com.daxtech.daxblog.enums.StateEnum;
import com.daxtech.daxblog.response.Response;
import com.daxtech.daxblog.service.AI.Business.WeatherBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WeatherHandler implements MessageStateHandle {

    private final WeatherBusinessService weatherBusinessService;

    @Override
    public StateEnum getState() {
        return StateEnum.WEATHER;
    }

    @Override
    public Response<String> handle(String message) {
        String msg = weatherBusinessService.getWeather(message);
        return Response.success(ResultCodeEnum.SUCCESS, msg);
    }
}
