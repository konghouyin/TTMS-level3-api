package com.xupt.ttms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xupt.ttms.Service.CommentService;
import com.xupt.ttms.dto.TransDTO;
import com.xupt.ttms.dto.returnDTO;
import com.xupt.ttms.dto.returnUTO;
import com.xupt.ttms.enums.returnType;
import com.xupt.ttms.model.Play;
import com.xupt.ttms.model.ReportType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    CommentService service;

    @PostMapping("/get")
    public Object getByPlay(@RequestBody String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TransDTO transDTO = mapper.readValue(json, TransDTO.class);

        Integer data = mapper.convertValue(transDTO.getData(), Play.class).getPlayId();
        System.out.println(data);

        List all;
        try {
           all = service.getByPlay(data);
        }catch (Exception e){
            returnUTO uto = new returnUTO();
            uto.setStyle(returnType.DATABASEERR.getStyle());
            uto.setMsg(returnType.DATABASEERR.getMsg());

            return uto;
        }

        returnDTO dto = new returnDTO();
        dto.setData(all);
        dto.setMsg("正常");
        dto.setStyle(1);

        return dto;
    }
}
