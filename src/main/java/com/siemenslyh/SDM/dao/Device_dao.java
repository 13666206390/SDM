package com.siemenslyh.SDM.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.siemenslyh.SDM.model.Device;




/**
 * Created by gxurn9 on 11/6/2017.
 */
@Component
public class Device_dao {

    @Autowired
    private MongoTemplate mongoTemplate;

    //保存一个Device到device集合里
    public boolean save(Device dev){
        Query query = new Query(Criteria.where("device_id").is(dev.getDevice_id()));

        if(mongoTemplate.exists(query,Device.class) == true) return false;

        mongoTemplate.save(dev,"device");
        return true;
    }

    //查询所有设备信息
    public List<Device> findAll(){
        return mongoTemplate.findAll(Device.class,"device");

    }

    //根据设备id查询
    public Device findById(String dev_id) {

        Query query = new Query(Criteria.where("device_id").is(dev_id));
        if (mongoTemplate.exists(query,Device.class) == false){
            return null;
        }
        return mongoTemplate.findOne(query, Device.class);

    }

    //更新数据
    public boolean update(Device dev){


        Query query = new Query(Criteria.where("device_id").is(dev.getDevice_id()));
        if (mongoTemplate.exists(query,Device.class) == false) return false;

        Update update = new Update();

        if(dev.getDevice_name() != null){
            update.set("device_name",dev.getDevice_name());
        }

        if(dev.getDevice_description() != null){
            update.set("device_description",dev.getDevice_description());
        }

        if(dev.getDevice_status() != null){
            update.set("device_status",dev.getDevice_status());
        }

        if(dev.getVarAttr().getVariable_name() != null){
            update.set("varAttr.variable_name",dev.getVarAttr().getVariable_name());
        }

        if(dev.getVarAttr().getUnit() != null){
            update.set("varAttr.unit",dev.getVarAttr().getUnit());
        }

        String[] getRange ;
        getRange = dev.getVarAttr().getData_range();

        if(getRange[0] != null ){
            update.set("varAttr.data_range",dev.getVarAttr().getData_range());
        }

        //更新返回的结果集的一条
        mongoTemplate.updateFirst(query,update,Device.class,"device");
        return true;

    }

    //删除数据
    public  boolean delete(String dev_id){
        Query query = new Query(Criteria.where("device_id").is(dev_id));

        if (mongoTemplate.exists(query,Device.class) == false) return false;

        mongoTemplate.remove(query,Device.class);
        return true;
    }
}
