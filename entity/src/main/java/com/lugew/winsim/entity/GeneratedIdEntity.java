package com.lugew.winsim.entity;


import com.lugew.winsim.entity.validator.Add;
import com.lugew.winsim.entity.validator.Delete;
import com.lugew.winsim.entity.validator.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.genid.GenId;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * 自增id实体
 *
 * @author LuGew
 */
@ApiModel
public class GeneratedIdEntity extends AbstractEntity<Long> {
    @Id
    @KeySql(genId = GenId.class)
    @ApiModelProperty(value = "uuid", example = "uuid")
    @Null(groups = {Add.class})
    @NotNull(groups = {Update.class, Delete.class})
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
