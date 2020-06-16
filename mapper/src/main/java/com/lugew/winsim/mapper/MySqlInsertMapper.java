package com.lugew.winsim.mapper;

import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.special.InsertUseGeneratedKeysMapper;

/**
 * mysql 独有通用mapper
 *
 * @author LuGew
 */
@RegisterMapper
public interface MySqlInsertMapper<T> extends
        InsertListNotUseGeneratedKeysMapper<T>,
        InsertUseGeneratedKeysMapper<T> {
}
