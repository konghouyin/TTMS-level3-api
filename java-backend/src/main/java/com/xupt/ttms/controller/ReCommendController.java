package com.xupt.ttms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xupt.ttms.Service.PlayService;
import com.xupt.ttms.dto.data;
import com.xupt.ttms.dto.playDTO;
import com.xupt.ttms.dto.returnDTO;
import com.xupt.ttms.dto.returnUTO;
import com.xupt.ttms.model.Play;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
public class ReCommendController {

    @Autowired
    PlayService service;

    @PostMapping("recommend/get")
    public Object getRecommend(){
        List<Play> recommend;
        try{

            recommend = service.getRecommend();
        }catch (Exception e){
            e.printStackTrace();
            returnUTO uto = new returnUTO();
            uto.setMsg("数据库异常");
            uto.setStyle(-2);
            return uto;
        }
        returnDTO dto = new returnDTO();
        dto.setMsg("查询成功");
        dto.setData(recommend);
        dto.setStyle(1);
        return dto;
    }

    @PostMapping("link/get")
    public Object getLink(){
        List<Play> links;
        try{

            links = service.getlink();
        }catch (Exception e){
            e.printStackTrace();
            returnUTO uto = new returnUTO();
            uto.setMsg("数据库异常");
            uto.setStyle(-2);
            return uto;
        }
        returnDTO dto = new returnDTO();
        dto.setMsg("查询成功");
        dto.setData(links);
        dto.setStyle(1);
        return dto;
    }

    @PostMapping("recommend/add")
    public Object updatePlayRecommend(@RequestBody String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        playDTO playDTO = objectMapper.readValue(json, playDTO.class);

        //获取输入参数
        data data = objectMapper.convertValue(playDTO.getData(), data.class);

        //
        returnUTO uto = new returnUTO();
        if(data.getType()!=1 && data.getType()!=2){
            uto.setMsg("参数异常");
            uto.setStyle(0);
        }
        int i = service.updatePlay(data);
        if (i==1){
            uto.setMsg("操作成功");
            uto.setStyle(1);
        }else if(i==2){
            uto.setMsg("查无剧目id");
            uto.setStyle(0);
        }else {
            uto.setMsg("数据库异常");
            uto.setStyle(-2);
        }
        return uto;
    }
}
