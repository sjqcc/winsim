package com.lugew.winsim.mapper;


import com.lugew.winsim.entity.Entity;
import tk.mybatis.mapper.annotation.RegisterMapper;

/**
 * 通用mysql mapper 带批量插入
 *
 * @param <T> 实体泛型一定要继承Entity接口
 */
@RegisterMapper
public interface MySqlMapper<T extends Entity<?>> extends Mapper<T>, MySqlInsertMapper<T> {
}
