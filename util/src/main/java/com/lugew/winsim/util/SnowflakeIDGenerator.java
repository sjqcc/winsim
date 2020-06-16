package com.lugew.winsim.util;

import tk.mybatis.mapper.genid.GenId;

public class SnowflakeIDGenerator implements GenId<Long> {
    @Override
    public Long genId(String table, String column) {
        return Snowflake.nextId();
    }
}