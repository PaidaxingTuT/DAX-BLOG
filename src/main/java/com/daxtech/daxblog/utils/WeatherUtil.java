package com.daxtech.daxblog.utils;

import com.daxtech.daxblog.enums.ResultCodeEnum;
import com.daxtech.daxblog.response.Response;
import dev.langchain4j.agent.tool.P;
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
public class WeatherUtil {

    @Value("${api.weather.key}")
    private String KEY;
    @Value("${api.weather.base-url}")
    private String BASE_URL;


    @Tool("查询城市天气")
    public String getWeather(@P("城市名称，不要带'市'或'区'，例如：青岛、济南") String city) {

        log.info("正在查询天气，城市: {}", city);

        try{
            String urlString = String.format(
                    "%s?city=%s&key=%s",
                    BASE_URL, city , KEY
            );

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlString))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();


        } catch (Exception e){
            return Response.faildata(ResultCodeEnum.SERVER_ERROR,"服务异常").toString();
        }


    }
}
