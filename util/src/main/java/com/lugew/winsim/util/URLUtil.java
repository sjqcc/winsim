package com.lugew.winsim.util;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LuGew
 * @since 2020/6/12
 */
@UtilityClass
public class URLUtil {
    public Map<String, Object> getParameters(String url) {
        Map<String, Object> result = new HashMap<>();
        String[] urlParts = url.split("\\?");
        if (urlParts.length > 1) {
            String[] params = urlParts[1].split("&");
            for (String param : params) {
                String[] keyValue = param.split("=");
                result.put(keyValue[0], keyValue[1]);
            }
        }
        return result;
    }
}
