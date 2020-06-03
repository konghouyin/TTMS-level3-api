package com.xupt.ttms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xupt.ttms.Service.UserWantService;
import com.xupt.ttms.dto.TransDTO;
import com.xupt.ttms.dto.returnDTO;
import com.xupt.ttms.dto.returnUTO;
import com.xupt.ttms.dto.userInfo;
import com.xupt.ttms.mapper.PlayMapper;
import com.xupt.ttms.model.Play;
import com.xupt.ttms.model.User;
import com.xupt.ttms.model.UserWant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("userwant")
public class UserWantController {

    @Autowired
    UserWantService service;
    @Autowired
    PlayMapper playMapper;

    @PostMapping("/get")
    public Object wangGet(@RequestBody String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TransDTO dto = mapper.readValue(json, TransDTO.class);

        Integer playId = mapper.convertValue(dto.getData(), UserWant.class).getPlayId();
        Integer userId = mapper.convertValue(dto.getUserInfo(), userInfo.class).getUser_id();

        Play play = playMapper.selectByPrimaryKey(playId);
        returnUTO uto = new returnUTO();
        if(play==null || play.getPlayStatus().equals("-1")){
            uto.setMsg("无此影片");
            uto.setStyle(0);

            return uto;
        }
        int byPlayId = service.getByPlayId(playId, userId);

        switch (byPlayId){
            case 1:{uto.setMsg("已想看");uto.setStyle(1);}break;
            case 0:{uto.setMsg("尚未添加想看");uto.setStyle(0);}break;
            case -2:{uto.setMsg("数据库异常");uto.setStyle(-2);}break;
            default:break;
        }
        return uto;
    }

    @PostMapping("/add")
    public Object wantAdd(@RequestBody String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TransDTO dto = mapper.readValue(json, TransDTO.class);

        Integer playId = mapper.convertValue(dto.getData(), UserWant.class).getPlayId();
        Integer userId = mapper.convertValue(dto.getUserInfo(), userInfo.class).getUser_id();
        returnUTO uto = new returnUTO();

        Play play = playMapper.selectByPrimaryKey(playId);
        if(play==null || play.getPlayStatus().equals("-1")){
            uto.setMsg("无此影片");
            uto.setStyle(0);

            return uto;
        }
        int i = service.wantAdd(playId, userId);

        switch (i){
            case 0:{uto.setMsg("用户已想看");uto.setStyle(0);}break;
            case 1:{uto.setMsg("添加成功");uto.setStyle(1);}break;
            case -2:{uto.setMsg("数据库异常");uto.setStyle(-2);}break;
            default:break;
        }

        return uto;
    }

    @PostMapping("/del")
    public Object wantDel(@RequestBody String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TransDTO dto = mapper.readValue(json, TransDTO.class);

        Integer playId = mapper.convertValue(dto.getData(), UserWant.class).getPlayId();
        Integer userId = mapper.convertValue(dto.getUserInfo(), userInfo.class).getUser_id();

        returnUTO uto = new returnUTO();
        Play play = playMapper.selectByPrimaryKey(playId);
        if(play==null || play.getPlayStatus().equals("-1")){
            uto.setMsg("无此影片");
            uto.setStyle(0);

            return uto;
        }
        int i = service.wantDel(playId, userId);

        switch (i){
            case 0:{uto.setMsg("用户已取消想看");uto.setStyle(0);}break;
            case 1:{uto.setMsg("删除成功");uto.setStyle(1);}break;
            case -2:{uto.setMsg("数据库异常");uto.setStyle(-2);}break;
            default:break;
        }

        return uto;
    }

    @PostMapping("/getAll")
    public Object getAll(@RequestBody String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TransDTO dto = mapper.readValue(json, TransDTO.class);

        Integer userId = mapper.convertValue(dto.getUserInfo(), userInfo.class).getUser_id();

        List<Object> all;
        try{
             all = service.getAll(userId);
        }catch (Exception e){
            e.printStackTrace();
            returnUTO uto = new returnUTO();
            uto.setMsg("数据库异常");
            uto.setStyle(-2);
            return uto;
        }
        returnDTO returnDTO = new returnDTO();
        returnDTO.setData(all);
        returnDTO.setMsg("正常");
        returnDTO.setStyle(1);

        return returnDTO;

    }
}
