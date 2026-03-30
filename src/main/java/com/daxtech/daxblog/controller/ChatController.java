package com.daxtech.daxblog.controller;

import com.daxtech.daxblog.enums.ResultCodeEnum;
import com.daxtech.daxblog.response.Response;
import com.daxtech.daxblog.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @GetMapping("/ask")
    public Response<String> chat(@RequestParam String message) {
        String msg = chatService.getMessage(message);
        if (msg.equals("无法回答。")) {
            return Response.faildata(ResultCodeEnum.FAIL,msg);
        }
        return Response.success(ResultCodeEnum.SUCCESS,msg);

    }
}
