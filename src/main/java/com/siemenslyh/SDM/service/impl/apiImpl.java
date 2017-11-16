package com.siemenslyh.SDM.service.impl;

import com.siemenslyh.SDM.dao.Device_dao;
import com.siemenslyh.SDM.model.Device;
import com.siemenslyh.SDM.model.Var_attr;
import com.siemenslyh.SDM.model.response.Resp;
import com.siemenslyh.SDM.model.response.RespCode;
import com.siemenslyh.SDM.service.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gxurn9 on 11/9/2017.
 */
@Service
public class apiImpl implements api {

    @Autowired
    private Device_dao device_dao;

    @Override
    public Resp add(Device dev){
        Resp resp;
        RespCode respcode = new RespCode();

        if(device_dao.save(dev) == true){
            respcode.setCode(200);
            respcode.setMsg("save suceess!");

            resp = new Resp(respcode);
        }
        else {
            respcode.setCode(400);
            respcode.setMsg("already have this id!");

            resp = new Resp(respcode);
        }
        return resp;

    }

    @Override
    public List<Device> findAll() {

        List<Device> list = device_dao.findAll();
        Resp resp;
        RespCode respcode = new RespCode();

        respcode.setCode(200);
        respcode.setMsg("find all success!");
        resp = new Resp(respcode,list);

        return list;

    }

    public Device findById(String device_id){
        Resp resp;
        RespCode respcode = new RespCode();
        Device dev = device_dao.findById(device_id);

        if (dev != null){
            respcode.setCode(200);
            respcode.setMsg("find by id success!");
            resp = new Resp(respcode,dev);
        }
        else {
            respcode.setCode(404);
            respcode.setMsg("don't have this id!");
            resp = new Resp(respcode);
        }

        return dev;

    }

    @Override
    public Resp updateById(Device dev) {

        Resp resp;
        RespCode respcode = new RespCode();

        if (dev.getDevice_id() == null) {
            respcode.setCode(403);
            respcode.setMsg("bad request");
            resp = new Resp(respcode);
            return  resp;
        }

        if(device_dao.update(dev) == false){
            respcode.setCode(400);
            respcode.setMsg("don't have this id!");
            resp = new Resp(respcode);
            return resp;
        }

        respcode.setCode(200);
        respcode.setMsg("update success!");
        resp = new Resp(respcode);
        return resp;

    }

    @Override
    public Resp deleteById(String device_id) {

        Resp resp;
        RespCode respcode = new RespCode();

        if(device_dao.delete(device_id) == false){
            respcode.setCode(400);
            respcode.setMsg("don't have this id!");
            resp = new Resp(respcode);
            return resp;
        }

        respcode.setCode(200);
        respcode.setMsg("delete success!");
        resp = new Resp(respcode);
        return resp;
    }

}
