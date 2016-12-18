package com.moli.core.model;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;
import com.moli.core.Const;

/**
 * 通用响应类.
 * @author Lo&Wang
 */
public class Response<T> implements Serializable {
    /**
     * 序列化.
     */
    private static final long serialVersionUID = -6454387275998929445L;
    /**
     * 数据.
     */
    private T data;
    /**
     * 错误码
     */
    private int error;
    /**
     * 消息.
     */
    private String msg;
    /**
     * 构造.
     * @param error 错误码
     */
    public Response(int error) {
        this.error = error;
    }
    /**
     * 构造.
     * @param data 数据
     */
    public Response(T data) {
        this.error = 0;
        this.data = data;
    }
    /**
     * 构造.
     * @param error 错误码
     * @param msg 错误消息
     */
    public Response(int error, String msg) {
        this.error = error;
        this.msg = msg;
    }
    /**
     * 构造.
     */
    public Response() {
        this.error = 0;
    }
    /**
     * 设置 数据.
     * @return data 数据.
     */
    public T getData() {
        return data;
    }
    /**
     * 获取 数据.
     * @param data 数据.
     */
    public void setData(T data) {
        this.data = data;
    }
    /**
     * 设置 错误码
     * @return error 错误码
     */
    public int getError() {
        return error;
    }
    /**
     * 获取 错误码
     * @param error 错误码
     */
    public void setError(int error) {
        this.error = error;
    }
    /**
     * 设置 消息.
     * @return msg 消息.
     */
    public String getMsg() {
        return msg;
    }
    /**
     * 获取 消息.
     * @param msg 消息.
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
    /**
     * jsonString .
     * @return .
     */
    public String toJSONString() {
        return JSON.toJSONString(this, Const.mapping);
    }
    public interface ERROR {
        /**
         * 无错误.
         */
        public static int NO_ERROR = 0;
        /**
         * 未知错误.
         */
        public static int UNKOWN_ERROR = 10000;
        /**
         * 授权错误.
         */
        public static int AUTH_ERROR = 10401;
        /**
         * 参数错误.
         */
        public static int PARAM_ERROR = 10300;
        /**
         * 系统错误.
         */
        public static int SYS_ERROR = 10500;
    }
}
