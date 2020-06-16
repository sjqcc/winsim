package com.lugew.winsim.controller;

import org.springframework.http.ResponseEntity;

/**
 * 控制层
 *
 * @author LuGew
 */
public interface Controller<T> {
    /**
     * 获取列表
     *
     * @param entity 实体
     * @return 标准响应实体
     */
    ResponseEntity<?> getList(T entity);

    /**
     * 获取分页列表
     *
     * @param entity 实体
     * @return 标准响应实体
     */
    ResponseEntity<?> getListPage(T entity);

    /**
     * 根据主键获取实体
     *
     * @param entity 实体
     * @return 标准响应实体
     */
    ResponseEntity<?> get(T entity);

    /**
     * 添加
     *
     * @param entity 实体
     * @return 标准响应实体
     */
    ResponseEntity<?> add(T entity);

    /**
     * 修改
     *
     * @param entity 实体
     * @return 标准响应实体
     */
    ResponseEntity<?> update(T entity);

    /**
     * 删除，逻辑删除
     *
     * @param entity 实体
     * @return 标准响应实体
     */
    ResponseEntity<?> delete(T entity);


}
