package com.lugew.winsim.controller.response;

import java.io.Serializable;

/**
 * 响应接口
 *
 * @author LuGew
 */
public interface Response<T> extends Serializable {

    /**
     * 获取响应码
     *
     * @return -1失败 0成功
     */
    int getCode();

    /**
     * 设置响应码
     *
     * @param code 响应码
     */
    void setCode(int code);

    /**
     * 获取数据
     *
     * @return 数据
     */
    T getData();

    /**
     * 设置数据
     *
     * @param data 数据
     */
    void setData(T data);

    /**
     * 获取消息
     *
     * @return 消息
     */
    String getMessage();

    /**
     * 设置消息
     *
     * @param message 获取消息
     */
    void setMessage(String message);

    /**
     * 失败
     */
    void fail();

    /**
     * 成功
     */
    void succeed();

    /**
     * 失败
     *
     * @param message 消息
     */
    void fail(String message);

    /**
     * 成功
     *
     * @param message 消息
     */
    void succeed(String message);


    /**
     * 失败
     *
     * @param message 消息
     * @param data    数据
     */
    void fail(T data, String message);

    /**
     * 成功
     *
     * @param message 消息
     * @param data    数据
     */
    void succeed(T data, String message);

    /**
     * 成功
     *
     * @param code    响应码
     * @param message 消息
     * @param data    数据
     */
    void succeed(int code, T data, String message);

    /**
     * 成功
     *
     * @param code    响应码
     * @param message 消息
     * @param data    数据
     */
    void fail(int code, T data, String message);
}
