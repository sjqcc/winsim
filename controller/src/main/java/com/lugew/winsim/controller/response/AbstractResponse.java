package com.lugew.winsim.controller.response;

/**
 * 抽象响应
 *
 * @author LuGew
 */
public class AbstractResponse<T> implements Response<T> {
    protected static final String SUCCESS_MESSAGE = "success";
    protected static final String FAILED_MESSAGE = "failed";
    protected static final int SUCCESS_CODE = 0;
    protected static final int FAILED_CODE = -1;

    protected int code = FAILED_CODE;
    protected T data;
    protected String message;

    public AbstractResponse() {
        this(SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    public AbstractResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public AbstractResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void fail() {
        fail(FAILED_MESSAGE);
    }

    @Override
    public void succeed() {
        succeed(SUCCESS_MESSAGE);
    }

    @Override
    public void fail(String message) {
        fail(null, message);
    }

    @Override
    public void succeed(String message) {
        succeed(null, message);
    }

    @Override
    public void fail(T data, String message) {
        fail(FAILED_CODE, data, message);
    }

    @Override
    public void succeed(T data, String message) {
        succeed(SUCCESS_CODE, data, message);
    }

    @Override
    public void succeed(int code, T data, String message) {
        build(code, data, message);
    }

    @Override
    public void fail(int code, T data, String message) {
        build(code, data, message);
    }

    protected void build(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

}
