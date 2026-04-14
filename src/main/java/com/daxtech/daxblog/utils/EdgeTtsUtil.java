package com.daxtech.daxblog.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.UUID;

@Slf4j
@Component
public class EdgeTtsUtil {

    private static final String AUDIO_DIR = "D:/Code/daxblog/audio/";

    public String textToSpeech(String text) {
        File dir = new File(AUDIO_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String fileName = UUID.randomUUID().toString() + ".mp3";
        String outputPath = AUDIO_DIR + fileName;

        ProcessBuilder processBuilder = new ProcessBuilder(
                "edge-tts",
                "--voice", "zh-CN-XiaoxiaoNeural",
                "--rate", "+10%",
                "--text", text,
                "--write-media", outputPath
        );

        try {
            log.info(">>> 开始生成语音，目标文件: {}", outputPath);

            Process process = processBuilder.start();
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                log.info(">>> 语音生成成功！");
                return outputPath;
            } else {
                log.error(">>> 语音生成失败，命令行退出码: {}", exitCode);
                return null;
            }

        } catch (Exception e) {
            log.error(">>> Edge TTS 转换发生异常", e);
            return null;
        }
    }
}