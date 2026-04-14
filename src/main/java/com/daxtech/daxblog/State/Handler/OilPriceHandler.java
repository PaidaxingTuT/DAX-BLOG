package com.daxtech.daxblog.State.Handler;

import com.daxtech.daxblog.State.MessageStateHandle;
import com.daxtech.daxblog.enums.ResultCodeEnum;
import com.daxtech.daxblog.enums.StateEnum;
import com.daxtech.daxblog.response.Response;
import com.daxtech.daxblog.service.AI.Business.OilPriceBusinessService;
import com.daxtech.daxblog.service.AI.Service.OilPriceAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OilPriceHandler implements MessageStateHandle {

    private final OilPriceBusinessService oilPriceBusinessService;

    @Override
    public StateEnum getState() {
        return StateEnum.OIL;
    }

    @Override
    public Response<String> handle(String message) {
        String msg = oilPriceBusinessService.getOilPrice(message);
        return Response.success(ResultCodeEnum.SUCCESS, msg);
    }
}
