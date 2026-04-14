package com.daxtech.daxblog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum ResultCodeEnum {

    SUCCESS("200","成功"),

    FAIL("500","失败"),

    IS_EMPTY("404","失败"),

    SERVER_ERROR("503","服务错误");

    private final String code;
    private final String message;
}