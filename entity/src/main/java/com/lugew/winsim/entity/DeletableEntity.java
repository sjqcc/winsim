package com.lugew.winsim.entity;


import com.lugew.winsim.entity.validator.Delete;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 删除实体
 *
 * @param <T> id类型
 * @author LuGew
 */
@Data
public abstract class DeletableEntity<T> implements Entity<T> {
    @ApiModelProperty(value = "删除标志0：正常；1：删除")
    @NotNull(groups = {Delete.class})
    private Boolean deleted;

}
