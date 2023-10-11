package com.mpsystem.utils;

/**
 * 全局统一返回结果类
 */
public class Result<T> {


    // 返回码
    private Integer code;
    // 返回消息
    private String message;
    // 返回数据
    private T data;
    private Integer total;
    public Result(){}
    // 返回数据
    protected static <T> Result<T> build(T data) {
        Result<T> result = new Result<T>();
        if (data != null)
            result.setData(data);
        return result;
    }

    protected static <T> Result<T> build(T data , Integer total) {
        Result<T> result = new Result<T>();
        if (data != null && total != null){
            result.setData(data);
            result.setTotal(total);
        }
        return result;
    }
    public static <T> Result<T> build(T body, Integer code, String message) {
        Result<T> result = build(body);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
    public static <T> Result<T> build(T body , ResultCodeEnum resultCodeEnum) {
        Result<T> result = build(body);
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }

    public static <T> Result<T> build(T body , Integer total, ResultCodeEnum resultCodeEnum) {
        Result<T> result = build(body , total);
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }

    /**
     * 操作成功
     * @param data  baseCategory1List
     * @param <T>
     * @return
     */
    public static<T> Result<T> upload(T data , Integer total){
        Result<T> result = build(data , total);
        return build(data,total, ResultCodeEnum.SUCCESS);
    }

    public static<T> Result<T> ok(T data){
        Result<T> result = build(data);
        return build(data, ResultCodeEnum.SUCCESS);
    }
    public Result<T> message(String msg){
        this.setMessage(msg);
        return this;
    }
    public Result<T> code(Integer code){
        this.setCode(code);
        return this;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public Integer getTotal(){
        return total;
    }
    public void setTotal(Integer total){
        this.total = total;
    }

    @Override
    public String toString() {
        return "Result{" +
                "total=" + total +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}