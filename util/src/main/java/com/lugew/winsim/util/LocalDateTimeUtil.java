package com.lugew.winsim.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

/**
 * 时间戳工具
 *
 * @author LuGew
 * @since 2020/5/2
 */
@UtilityClass
public class LocalDateTimeUtil {
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
