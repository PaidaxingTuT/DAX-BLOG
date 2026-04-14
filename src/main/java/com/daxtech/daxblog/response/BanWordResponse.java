package com.daxtech.daxblog.response;

import dev.langchain4j.model.output.structured.Description;

public record BanWordResponse(

        @Description("内容是否安全，安全为true，不安全为false。")
        boolean isSafe,

        @Description("如果包含违禁词，说明触发了哪类违禁规则，详细的违规理由，必须具体且有针对性，禁止泛泛而谈；如果正常，返回空字符串。")
        String reason
) {
}
