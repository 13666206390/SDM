package com.siemenslyh.SDM.model.response;

/**
 * Created by gxurn9 on 11/9/2017.
 */
public class RespCode {

    private int code;
    private String msg;

    public void setCode(int co){
        this.code = co;
    }

    public void setMsg(String ms){
        this.msg = ms;
    }

    public int getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }
}
