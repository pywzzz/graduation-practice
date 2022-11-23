package com.pywzzz.graduation_practice.util;

import lombok.Data;

@Data
public class Result<T> {
    //数据状态编码
    private Integer code;
    //返回提示信息
    private String msg;
    //返回数据的记录数
    private long count;
    //数据记录
    private T data;

    public Result(Integer code, String msg, long count, T data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }
}
