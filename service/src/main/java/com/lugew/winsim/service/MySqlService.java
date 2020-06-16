package com.lugew.winsim.service;


import com.lugew.winsim.entity.Entity;

import java.util.List;

/**
 * mysql 业务逻辑接口
 *
 * @author LuGew
 */
public interface MySqlService<T extends Entity<?>> extends Service<T> {
    /**
     * 批量插入，支持批量插入的数据库可以使用，例如MySQL,H2等。
     *
     * @param entityList 列表
     * @return 1 成功
     */
    int insertList(List<? extends T> entityList);


}
