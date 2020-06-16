package com.lugew.winsim.entity;


import io.swagger.annotations.ApiModel;

/**
 * 抽象实体
 *
 * @param <T> id类型
 * @author LuGew
 */
@ApiModel
public abstract class AbstractEntity<T> extends ModifiableEntity<T> {
}
