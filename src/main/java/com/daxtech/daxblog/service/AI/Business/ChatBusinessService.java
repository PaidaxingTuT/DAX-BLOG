package com.daxtech.daxblog.service.AI.Business;

import com.daxtech.daxblog.enums.ResultCodeEnum;
import com.daxtech.daxblog.response.Response;
import com.daxtech.daxblog.service.AI.Service.ChatAiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatBusinessService{

    private final ChatAiService chatService;

    public String chat(String userMessage) {
        log.info("派大星AI>>>收到用户提问: {}", userMessage);

        LocalDate today = LocalDate.now();
        int month = today.getMonthValue();

        String currentCity;
        if (month == 1 || month == 2 || month == 7 || month == 8) {
            currentCity = "平度";
        } else {
            currentCity = "东昌府";
        }

        try {
            String response = chatService.chat(userMessage, currentCity);

            log.info("派大星AI>>>回复内容: {}", response);
            return response;
        } catch (Exception e) {
            log.error("调用大模型服务发生异常: ", e);
            return Response.faildata(ResultCodeEnum.SERVER_ERROR, "服务异常").toString();
        }
    }

}