package com.awantunai.test.demo.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EncryptUtil {
    public static String encrypt(String str) {
        return Base64.getEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8));
    }

    public static String decrypt(String str) {
        byte[] bytes = Base64.getDecoder().decode(str);
        return new String(bytes);
    }
}
