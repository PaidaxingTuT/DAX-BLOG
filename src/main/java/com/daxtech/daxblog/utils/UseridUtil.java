package com.daxtech.daxblog.utils;


public class UseridUtil {

    private static final String HEAD = "USER-";

    public String generateUserID()
    {
        String uuid = java.util.UUID.randomUUID().toString().replace("-", "").substring(0, 6);
        return HEAD + uuid;
    }
}
