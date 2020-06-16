package com.lugew.winsim.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Transient;

/**
 * @author LuGew
 * @since 2020/5/2
 */
public class PageEntity extends SnowflakeIDEntity implements Page {
    @Transient
    @ApiModelProperty(hidden = true)
    private Integer pageNum;

    @Transient
    @ApiModelProperty(hidden = true)
    private Integer pageSize;

    @Override
    public Integer getPageNum() {
        return pageNum;
    }

    @Override
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public Integer getPageSize() {
        return pageSize;
    }

    @Override
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
