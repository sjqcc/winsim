package com.lugew.winsim.util;

import java.util.UUID;

public class UUIDUtil {


    /**
     * 去除UUID ‘-’
     *
     * @return uuid string
     */
    public static String generate() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

    /**
     * UUID含‘-’
     *
     * @return uuid string with hyphen
     */
    public static String generateWithHyphen() {
        return UUID.randomUUID().toString();
    }
}