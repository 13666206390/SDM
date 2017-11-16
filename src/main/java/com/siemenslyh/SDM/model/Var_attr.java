package com.siemenslyh.SDM.model;

/**
 * Created by gxurn9 on 11/6/2017.
 */
public class Var_attr {

    private String variable_name;
    private String unit;
    private String[] data_range = new String[2];

    public String getVariable_name(){
        return variable_name;
    }

    public void setVariable_name(String name){
        this.variable_name = name;
    }

    public String getUnit(){
        return unit;
    }

    public void setUnit(String uni){
        this.unit = uni;
    }

    public String[] getData_range(){
        return data_range;
    }

    public void setData_range(String[] range){
        System.arraycopy(range,0,data_range,0,2);
    }

}
