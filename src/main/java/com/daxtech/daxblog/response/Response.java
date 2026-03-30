package com.daxtech.daxblog.response;

import com.daxtech.daxblog.enums.ResultCodeEnum;
import lombok.Data;

@Data
public class Response<T> {
    private String code;
    private String msg;
    private T data;

    public static <T> Response<T> buildResult(ResultCodeEnum resultCodeEnum, T data) {
        Response<T> response = new Response<>();
        response.setCode(resultCodeEnum.getCode());
        response.setMsg(resultCodeEnum.getMessage());
        response.setData(data);
        return response;
    }

    public static <T> Response<T> success(ResultCodeEnum resultCodeEnum, T data) {
        return buildResult(resultCodeEnum, data);
    }

    public static <T> Response<T> fail(ResultCodeEnum resultCodeEnum) {
        return buildResult(resultCodeEnum, null);
    }

    public static <T> Response<T> faildata(ResultCodeEnum resultCodeEnum, T data) {
        return buildResult(resultCodeEnum, data);
    }

}
