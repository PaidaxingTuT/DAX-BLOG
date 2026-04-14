package com.daxtech.daxblog.service.AI.Business;

import com.daxtech.daxblog.utils.EdgeTtsUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.apache.commons.lang3.BooleanUtils.ON;
import static org.apache.commons.lang3.BooleanUtils.OFF;

@RequiredArgsConstructor
@Service
@Slf4j
public class EdgeTTSServiceImp {

    private static final String KEY = OFF;
    private final EdgeTtsUtil edgeTtsUtil;

    public String tts(String textResponse) {

        if (Objects.equals(KEY, ON)) {

            String audioFilePath = edgeTtsUtil.textToSpeech(textResponse);
            if (audioFilePath != null) {
                log.info("音频已就绪，准备下发给前端，路径：{}", audioFilePath);
                return textResponse;

                // + "\n[音频已生成，存储在: " + audioFilePath + "]";
            }
        }
        return textResponse;
    }
}
