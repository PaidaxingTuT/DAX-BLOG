package com.daxtech.daxblog.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.langchain4j.agent.tool.Tool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
@Component
public class OilPriceUtil {

    @Value("${api.oil.base-url}")
    private String BASE_URL;

    @Tool("获取指定省份的今日油价。参数 province 必须是省份名称，例如：'山东'、'北京市'。")
    public String getOilPrice(String province) {

        log.info("正在查询油价，省份: {}", province);


        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL))
                    .GET()
                    .build();


            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String rawFullJson = response.body();


            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(rawFullJson);
            JsonNode dataArray = root.get("data");


            if (dataArray != null && dataArray.isArray()) {
                for (JsonNode node : dataArray) {
                    String regionName = node.get("regionName").asText();
                    if (regionName.contains(province)) {
                        return node.toString();
                    }
                }
            }
            return "未找到该省份信息。";

        } catch (Exception e) {

            log.error("获取油价数据失败: ", e);
            return "暂无该省份油价数据。";
        }
    }
}