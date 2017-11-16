package com.siemenslyh.SDM.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by gxurn9 on 11/6/2017.
 */
@Document(collection = "device")
public class Device {

    @Id
    private String device_id;
    private String device_name;
    private String device_description;
    private String device_status;
    private Var_attr varAttr;

    public String getDevice_id(){
        return device_id;
    }

    public void setDevice_id(String id){
        this.device_id = id;
    }

    public String getDevice_name(){
        return device_name;
    }

    public void setDevice_name(String name){
        this.device_name = name;
    }

    public String getDevice_description(){
        return device_description;
    }

    public void setDevice_description(String description){
        this.device_description = description;
    }

    public String getDevice_status(){
        return device_status;
    }

    public void setDevice_status(String status){
        this.device_status = status;
    }

    public Var_attr getVarAttr(){
        return varAttr;
    }

    public void setVarAttr(Var_attr var){
        this.varAttr = var;
    }

}
