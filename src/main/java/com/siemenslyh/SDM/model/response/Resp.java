package com.siemenslyh.SDM.model.response;

/**
 * Created by gxurn9 on 11/9/2017.
 */
public class Resp {

    private RespCode respCode;
    private Object Odata;

    public Resp(RespCode resp){
        this.respCode = resp;
    }

    public Resp(RespCode resp,Object odata){
        this.respCode = resp;
        this.Odata = odata;
    }

    public RespCode getRespCode(){
        return respCode;
    }

    public Object getOdata(){
        return Odata;
    }
}
