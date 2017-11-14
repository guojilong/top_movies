package com.gjl.topmovies.model;

import java.io.Serializable;

/**
 * Created by guojilong on 2017/11/13.
 */
public class Response<T> implements Serializable {
    public static final  Integer OK=200;
    public static final Integer ERR=500;
    private Integer status;
    private String err;

    @Override
    public String toString() {
        return "Response{" +
                "status=" + status +
                ", err='" + err + '\'' +
                ", data=" + data +
                '}';
    }

    private T data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    public static <T> Response<T> ok() {
        Response r = new Response();
        r.status = OK;
        return r;
    }

    public static <T> Response<T> ok(Object data) {
        Response r = new Response();
        r.status = OK;
        r.data = data;
        return r;
    }

    public static <T> Response<T> notOk(String err) {
        Response r = new Response();
        r.status = ERR;
        r.err = err;
        return r;
    }

    public static <T> Response<T> notOk(Integer status, String err) {
        Response r = new Response();
        r.status = status;
        r.err = err;
        return r;
    }

}
