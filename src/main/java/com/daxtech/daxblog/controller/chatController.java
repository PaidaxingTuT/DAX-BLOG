package com.daxtech.daxblog.controller;

import com.daxtech.daxblog.service.AIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class chatController {

    private AIService AIService;

    @GetMapping("/ask")
    public String chat(@RequestParam String message) {
        return AIService.chat(message);

    }
}
