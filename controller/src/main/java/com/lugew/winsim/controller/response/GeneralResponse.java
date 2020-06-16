package com.lugew.winsim.controller.response;

/**
 * 通用响应
 *
 * @param <T> 数据泛型
 */
public class GeneralResponse<T> extends AbstractResponse<T> {


    private GeneralResponse() {
        super();
    }

    public static <T> GeneralResponse<T> build() {
        return new GeneralResponse<T>();
    }
}
