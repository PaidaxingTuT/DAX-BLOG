package com.daxtech.daxblog.service.AI.Business;

import com.daxtech.daxblog.enums.ResultCodeEnum;
import com.daxtech.daxblog.response.Response;
import com.daxtech.daxblog.service.AI.Service.OilPriceAiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OilPriceBusinessService {


    private final OilPriceAiService oilPriceAiService;

    public String getOilPrice(String userMessage) {
        log.info("油价>>>大模型获取的消息为: {}", userMessage);
        try {
            String textResponse = oilPriceAiService.getOilPrice(userMessage);
            log.info("油价播报文字回复: {}", textResponse);
            return textResponse;
        } catch (Exception e) {
            log.error("服务处理异常: ", e);
            return Response.faildata(ResultCodeEnum.SERVER_ERROR, "服务异常").toString();

        }
    }
}
