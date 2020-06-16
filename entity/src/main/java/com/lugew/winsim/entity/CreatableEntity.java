package com.lugew.winsim.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 创建实体
 *
 * @param <T> id类型
 * @author LuGew
 */
@Data
public abstract class CreatableEntity<T> extends DeletableEntity<T> {
    @ApiModelProperty(value = "创建人", example = "admin", hidden = true)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long creator;

    @ApiModelProperty(value = "创建时间", example = "1999-01-01 12:00:00", hidden = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDateTime;

}
