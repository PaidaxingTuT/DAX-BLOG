package com.daxtech.daxblog.controller;

import com.daxtech.daxblog.State.Handler.BanWordHandler;
import com.daxtech.daxblog.State.Handler.ChatHandler;
import com.daxtech.daxblog.State.Handler.OilPriceHandler;
import com.daxtech.daxblog.State.Handler.WeatherHandler;
import com.daxtech.daxblog.enums.ResultCodeEnum;
import com.daxtech.daxblog.enums.StateEnum;
import com.daxtech.daxblog.response.Response;
import com.daxtech.daxblog.service.AI.Business.StateBusinessService;
import com.daxtech.daxblog.service.AI.Business.WeatherBusinessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/state")
@RequiredArgsConstructor
public class StateController {

    private final StateBusinessService stateBusinessService;

    private final BanWordHandler banWordHandler;
    private final WeatherHandler weatherHandler;
    private final ChatHandler chatHandler;
    private final OilPriceHandler oilPriceHandler;

    private int times = 0;


    @GetMapping
    public Response<String> handle(@RequestParam String message) {
        if (times < 3) {
            if (Objects.equals(message, "") || message == null) {
                return Response.faildata(ResultCodeEnum.IS_EMPTY, "消息为空");
            }

            StateEnum state = stateBusinessService.getState(message);

            switch (state) {
                case ABOUT -> {
                    return chatHandler.handle(message);
                }
                case WEATHER -> {
                    return weatherHandler.handle(message);
                }
                case BAN -> {
                    times++;
                    log.info("违规次数: {}", times);
                    return banWordHandler.handle(message);
                }
                case OIL -> {
                    return oilPriceHandler.handle(message);
                }
                default -> {
                    return Response.faildata(ResultCodeEnum.IS_EMPTY, "无法识别的状态");
                }
            }

        } else {
            return Response.faildata(ResultCodeEnum.SERVER_ERROR, "违规次数过多，无法使用");
        }
    }


}
