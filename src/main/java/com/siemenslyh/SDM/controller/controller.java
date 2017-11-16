package com.siemenslyh.SDM.controller;

import com.siemenslyh.SDM.model.Device;
import com.siemenslyh.SDM.model.response.Resp;
import com.siemenslyh.SDM.service.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by gxurn9 on 11/6/2017.
 */
@RestController
@RequestMapping("/SDM")
public class controller {

    @Autowired
    private api Api;

    //控制添加方法
    @PostMapping("/add")
    public Resp add(@RequestBody Device reqDevice){
        return Api.add(reqDevice);

    }

    //查询所有数据
    @GetMapping("/findAll")
    public List<Device> findAll(){
        return Api.findAll();
    }

    //根据id查询设备
    @GetMapping("/findById/{device_id}")
    public Device findById(@PathVariable("device_id") String device_id){
        return Api.findById(device_id);
    }

    @PutMapping("/updateById")
    public Resp updateById(@RequestBody Device reqDevice){
        return  Api.updateById(reqDevice);
    }

    @DeleteMapping("deleteById/{device_id}")
    public Resp deleteById(@PathVariable("device_id") String device_id){
        return Api.deleteById(device_id);
    }


}
