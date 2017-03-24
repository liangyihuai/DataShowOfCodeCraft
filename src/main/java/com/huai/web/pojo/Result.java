package com.huai.web.pojo;

/**
 * 保存函数返回的结果
 * Created by liangyh on 3/24/2017.
 */
public class Result {
    private Object data;
    private boolean good = false;

    public Result() {
    }

    public Result(Object data, boolean condition) {
        this.data = data;
        this.good = condition;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isGood() {
        return good;
    }

    public void setGood(boolean good) {
        this.good = good;
    }
}
