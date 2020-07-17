package com.qf.vo;

import lombok.Data;

@Data
public class R <T>{
    private int code;
    private String msg;
    private T data;

    public R() {
    }

    public R(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    //成功
    public static <E> R ok(E obj){
        return new R(200,"OK",obj);
    }
    public static R ok(){
        return new R(200,"OK",null);
    }
    //失败
    public static <E> R error(String msg){
        return new R(400,msg,null);
    }

}
