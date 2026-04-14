package com.daxtech.daxblog.service.AI.Business;

import com.daxtech.daxblog.enums.ResultCodeEnum;
import com.daxtech.daxblog.response.BanWordResponse;
import com.daxtech.daxblog.response.Response;
import com.daxtech.daxblog.service.AI.Service.BanWordAiService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Data
@Slf4j
public class BanWordBusinessService{


    private final BanWordAiService banWordService;

    public String banWord(String userMessage) {
        log.info("违禁词>>>用户输入语句: {}", userMessage);
        BanWordResponse result = banWordService.banWord(userMessage);

        if (!result.isSafe()) {
            log.info("违规原因: {}", result.reason());
        }
        return userMessage;
    }
}