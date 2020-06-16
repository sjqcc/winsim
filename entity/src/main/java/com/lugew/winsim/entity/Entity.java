package com.lugew.winsim.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基础实体接口
 *
 * @param <T> id类型
 * @author LuGew
 */
public interface Entity<T> extends Serializable {

    T getId();

    void setId(T id);

    Boolean getDeleted();

    void setDeleted(Boolean deleted);

    Long getCreator();

    void setCreator(Long creator);

    LocalDateTime getCreateDateTime();

    void setCreateDateTime(LocalDateTime createDateTime);

    Long getModifier();

    void setModifier(Long modifier);

    LocalDateTime getModifyDateTime();

    void setModifyDateTime(LocalDateTime modifyDateTime);
}
