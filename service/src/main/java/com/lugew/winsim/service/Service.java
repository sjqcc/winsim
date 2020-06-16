package com.lugew.winsim.service;


import com.github.pagehelper.PageInfo;
import com.lugew.winsim.entity.Entity;

import java.util.List;


/**
 * 业务逻辑层接口
 * 删除皆时逻辑删除
 *
 * @author LuGew
 */
public interface Service<T extends Entity<?>> {
    /**
     * 插入实体，null属性也会保存，不会使用数据库默认值
     *
     * @param entity 实体
     * @return 0成功，1失败
     */
    int insert(T entity);

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     *
     * @param entity 实体
     * @return 0成功，1失败
     */
    int insertNotNull(T entity);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     *
     * @param entity 实体
     * @return 0成功，1失败
     */
    int update(T entity);

    /**
     * 根据主键更新属性不为null的值
     *
     * @param entity 实体
     * @return 0成功，1失败
     */
    int updateNotNull(T entity);

    /**
     * 根据Example条件更新实体`record`包含的全部属性，null值会被更新
     *
     * @param entity  实体
     * @param example example
     * @return 0成功，1失败
     */
    int updateByExample(T entity, Object example);

    /**
     * 根据Example条件更新实体`record`包含的不是null的属性值
     *
     * @param entity  实体
     * @param example example
     * @return 0成功，1失败
     */
    int updateByExampleNotNull(T entity, Object example);

    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号
     *
     * @param entity 实体
     * @return 0成功，1失败
     */
    int delete(T entity);

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     *
     * @param key 主键
     * @return 0成功，1失败
     */
    int delete(Object key);

    /**
     * 根据Example条件删除数据
     *
     * @param example example
     * @return 0成功，1失败
     */
    int deleteByExample(Object example);

    /**
     * 根据Example条件进行查询
     *
     * @param example example
     * @return 单个实体
     */
    T getOneByExample(Object example);

    /**
     * 根据Example条件进行查询总数
     *
     * @param example example
     * @return 总数
     */
    int getCountByExample(Object example);

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     *
     * @param entity 实体
     * @return 总数
     */
    int selectCount(T entity);

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     *
     * @param entity 实体
     * @return 实体
     */
    T getOne(T entity);

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     *
     * @param key 主键
     * @return 实体
     */
    T get(Object key);

    /**
     * 根据主键字段查询总数，方法参数必须包含完整的主键属性，查询条件使用等号
     *
     * @param key 主键
     * @return true 存在
     */

    boolean exists(Object key);

    /**
     * 根据Example条件进行查询
     *
     * @param example example
     * @return 实体列表
     */
    List<T> getListByExample(Object example);

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     *
     * @param entity
     * @return 实体列表
     */
    List<T> getList(T entity);

    /**
     * 根据实体进行分页
     *
     * @param entity 实体
     * @return 分页
     */
    PageInfo<T> getListPage(T entity);
}
