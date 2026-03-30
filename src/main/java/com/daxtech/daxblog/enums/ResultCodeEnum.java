package com.daxtech.daxblog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum ResultCodeEnum {

    SUCCESS("200","成功"),

    FAIL("500","失败");

    private final String code;
    private final String message;
}