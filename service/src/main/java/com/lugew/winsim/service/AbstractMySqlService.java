package com.lugew.winsim.service;


import com.lugew.winsim.entity.Entity;
import com.lugew.winsim.mapper.MySqlMapper;

import java.util.List;

/**
 * 抽象mysql业务逻辑
 *
 * @author LuGew
 */
public abstract class AbstractMySqlService<T extends Entity<?>, I extends MySqlMapper<T>>
        extends AbstractService<T, I>
        implements MySqlService<T> {

    @Override
    public int insertList(List<? extends T> recordList) {
        return mapper.insertList(recordList);
    }


}
