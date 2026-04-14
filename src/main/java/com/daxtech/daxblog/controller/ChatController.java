package com.daxtech.daxblog.controller;

import com.daxtech.daxblog.enums.ResultCodeEnum;
import com.daxtech.daxblog.response.Response;
import com.daxtech.daxblog.service.AI.Business.BanWordBusinessService;
import com.daxtech.daxblog.service.AI.Business.ChatBusinessService;
import com.daxtech.daxblog.service.AI.Business.WeatherBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ChatController {

    private final ChatBusinessService chatBusinessService;

    private final WeatherBusinessService weatherBusinessService;

    private final BanWordBusinessService banWordBusinessService;

    @GetMapping("/about")
    public Response<String> chat(@RequestParam String message) {
        if(Objects.equals(message, "") || message ==  null) {
            return Response.faildata(ResultCodeEnum.IS_EMPTY,"消息为空");
        }
        String msg = chatBusinessService.chat(message);
        if (msg.equals("无法回答。")) {
            return Response.faildata(ResultCodeEnum.FAIL,msg);
        }
        return Response.success(ResultCodeEnum.SUCCESS,msg);

    }

    @GetMapping("/weather")
    public Response<String> getWeather(@RequestParam String city){
        if(Objects.equals(city, "") || city ==  null) {
            return Response.faildata(ResultCodeEnum.IS_EMPTY,"城市为空");
        }
        String msg = weatherBusinessService.getWeather(city);
        return  Response.success(ResultCodeEnum.SUCCESS,msg);
    }

    @GetMapping("/ban")
    public Response<String> textCheck(@RequestParam String message) {
        if(Objects.equals(message, "") || message ==  null) {
            return Response.faildata(ResultCodeEnum.IS_EMPTY,"消息为空");
        }
        return Response.success(ResultCodeEnum.SUCCESS,banWordBusinessService.banWord(message));
    }
}
