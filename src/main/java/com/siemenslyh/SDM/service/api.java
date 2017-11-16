package com.siemenslyh.SDM.service;

import com.siemenslyh.SDM.model.Device;
import com.siemenslyh.SDM.model.response.Resp;

import java.util.List;

/**
 * Created by gxurn9 on 11/9/2017.
 */
public interface api {

    //添加接口
    Resp add(Device dev);

    //查询所有表接口
    List<Device> findAll();

    //根据id查询接口
    Device findById(String device_id);

    //根据id更新接口
    Resp updateById(Device dev);

    //根据id删除接口
    Resp deleteById(String device_id);

}
