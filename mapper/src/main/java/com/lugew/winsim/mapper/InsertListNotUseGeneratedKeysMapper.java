package com.lugew.winsim.mapper;

import org.apache.ibatis.annotations.InsertProvider;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.provider.SpecialProvider;

import java.util.List;

/**
 * 通用Mapper接口,特殊方法，批量插入，支持批量插入的数据库都可以使用，例如mysql,h2等
 *
 * @param <T>不能为空
 * @author LuGew
 */
@RegisterMapper
public interface InsertListNotUseGeneratedKeysMapper<T> {
    /**
     * 批量插入，支持批量插入的数据库可以使用，例如MySQL,H2等。
     *
     * @param recordList 列表
     * @return 1 成功
     */
    @InsertProvider(type = SpecialProvider.class, method = "dynamicSQL")
    int insertList(List<? extends T> recordList);
}
