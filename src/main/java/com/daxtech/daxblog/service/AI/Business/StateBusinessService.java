package com.daxtech.daxblog.service.AI.Business;

import com.daxtech.daxblog.enums.StateEnum;
import com.daxtech.daxblog.service.AI.Service.StateAiService;
import dev.langchain4j.service.UserMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class StateBusinessService{

    private final StateAiService stateAiService;


    public StateEnum getState(@UserMessage String userMessage){
        log.info("用户输入的消息为: {}", userMessage);
        StateEnum response = stateAiService.getState(userMessage);
        log.info("大模型获取的状态为: {}", response);
        return response;
    }


}
