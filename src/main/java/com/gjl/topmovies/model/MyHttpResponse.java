package com.gjl.topmovies.model;

/**
 * Created by guojilong on 2017/11/13.
 */
public class MyHttpResponse {
    private int code;
    private String data;
    private String msg;

    public static MyHttpResponse ok(Object data) {
        MyHttpResponse r = new MyHttpResponse();
        r.code = 200;
        r.data = String.valueOf(data);
        return r;
    }

    public static MyHttpResponse notOk(String errMsg) {
        MyHttpResponse r = new MyHttpResponse();
        r.code = 500;
        r.msg = errMsg;
        return r;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
