package com.lugew.winsim.mapper;


import com.lugew.winsim.entity.Entity;
import tk.mybatis.mapper.annotation.RegisterMapper;

/**
 * 通用基础mapper
 *
 * @param <T> 实体泛型一定要继承Entity接口
 */
@RegisterMapper
public interface GeneralMapper<T extends Entity<?>> extends Mapper<T> {
}
