package com.lugew.winsim.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 更新实体
 *
 * @param <T> id类型
 * @author LuGew
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class ModifiableEntity<T> extends CreatableEntity<T> {
    @ApiModelProperty(value = "更新人", example = "admin", hidden = true)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long modifier;

    @ApiModelProperty(value = "更新时间", example = "1999-01-02 12:00:00", hidden = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifyDateTime;

}
