package com.daxtech.daxblog.State.Handler;

import com.daxtech.daxblog.State.MessageStateHandle;
import com.daxtech.daxblog.enums.ResultCodeEnum;
import com.daxtech.daxblog.enums.StateEnum;
import com.daxtech.daxblog.response.Response;
import com.daxtech.daxblog.service.AI.Business.BanWordBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BanWordHandler implements MessageStateHandle {

    private final BanWordBusinessService banWordBusinessService;

    @Override
    public StateEnum getState() {
        return StateEnum.BAN;
    }

    @Override
    public Response<String> handle(String message) {

        String msg = banWordBusinessService.banWord(message);

        if (msg.contains("内容违规")) {
            return Response.faildata(ResultCodeEnum.FAIL, msg);
        } else {
            return Response.success(ResultCodeEnum.SUCCESS, msg);
        }
    }
}