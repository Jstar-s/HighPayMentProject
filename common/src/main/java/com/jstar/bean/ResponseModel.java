package com.jstar.bean;

/**
 * @author Jayson
 * @version 1.0
 * @date 2023/12/24 16:04
 */
public  class ResponseModel<T> {

    public T data;

    public Integer code;

    public String info;

    public Integer total;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public static <T> ResponseModel success(T data) {
        ResponseModel<T> response = new ResponseModel<>();
        response.setData(data);
        response.setCode(200);
        return response;
    }
}
