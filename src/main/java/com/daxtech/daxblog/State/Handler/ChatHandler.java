package com.daxtech.daxblog.State.Handler;

import com.daxtech.daxblog.State.MessageStateHandle;
import com.daxtech.daxblog.enums.ResultCodeEnum;
import com.daxtech.daxblog.enums.StateEnum;
import com.daxtech.daxblog.response.Response;
import com.daxtech.daxblog.service.AI.Business.ChatBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChatHandler implements MessageStateHandle {


    private final ChatBusinessService chatService;

    @Override
    public StateEnum getState() {
        return StateEnum.ABOUT;
    }

    @Override
    public Response<String> handle(String message) {
        String msg = chatService.chat(message);
        if ("无法回答。".equals(msg)) {
            return Response.faildata(ResultCodeEnum.FAIL, msg);
        }
        return Response.success(ResultCodeEnum.SUCCESS, msg);
    }
}
