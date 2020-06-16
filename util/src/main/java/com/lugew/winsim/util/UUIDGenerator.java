package com.lugew.winsim.util;


import tk.mybatis.mapper.genid.GenId;

public class UUIDGenerator implements GenId<String> {
    @Override
    public String genId(String table, String column) {
        return UUIDUtils.generate();
    }
}