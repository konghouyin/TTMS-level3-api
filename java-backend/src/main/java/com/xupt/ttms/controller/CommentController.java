package com.xupt.ttms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xupt.ttms.Service.CommentService;
import com.xupt.ttms.dto.TransDTO;
import com.xupt.ttms.dto.returnDTO;
import com.xupt.ttms.dto.returnUTO;
import com.xupt.ttms.enums.CommentEnum;
import com.xupt.ttms.enums.returnType;
import com.xupt.ttms.model.Comment;
import com.xupt.ttms.model.Play;
import com.xupt.ttms.model.ReportType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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
        //System.out.println(data);

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


    @PostMapping("/add")
    public returnUTO commentAdd(@RequestBody String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TransDTO transDTO = mapper.readValue(json, TransDTO.class);

        Comment comment = mapper.convertValue(transDTO.getData(), Comment.class);
        short status = (short) CommentEnum.GOOD.getType();
        Date date = new Date();
        comment.setCommentStatus(status);
        comment.setCommentTime(date);
        comment.setUserId(transDTO.getUserInfo().getUser_id());

        int i = service.commentAdd(comment);
        returnUTO uto = new returnUTO();
        if(i==0){
            uto.setStyle(returnType.DATABASEERR.getStyle());
            uto.setMsg(returnType.DATABASEERR.getMsg());
        }else {
            uto.setStyle(returnType.SUCCESS.getStyle());
            uto.setMsg(returnType.SUCCESS.getMsg());
        }


        return uto;
    }


    //举报列表
    @PostMapping("report")
    public Object getByStatus(){
        List<Comment> byStatus;
        try {
            byStatus = service.getByStatus();
        }catch (Exception e){
            returnUTO uto = new returnUTO();
            uto.setStyle(returnType.DATABASEERR.getStyle());
            uto.setMsg(returnType.DATABASEERR.getMsg());

            return uto;
        }

        returnDTO dto = new returnDTO();
        dto.setData(byStatus);
        dto.setMsg("正常");
        dto.setStyle(1);

        return dto;

    }
    //删除

    @PostMapping("/del")
    public returnUTO delComment(@RequestBody String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TransDTO dto = mapper.readValue(json, TransDTO.class);

        Comment comment = mapper.convertValue(dto.getData(), Comment.class);
        boolean b = service.delComment(comment);

        returnUTO uto = new returnUTO();
        if(!b){
           uto.setMsg("数据库异常");
           uto.setStyle(-2);
        }
        uto.setMsg("删除成功");
        uto.setStyle(1);
        return uto;
    }

    //驳回
    @PostMapping("/reject")
    public returnUTO rejComment(@RequestBody String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TransDTO dto = mapper.readValue(json,TransDTO.class);

        Comment comment = mapper.convertValue(dto.getData(),Comment.class);
        boolean b = service.rejectComment(comment);

        returnUTO uto = new returnUTO();
        if(!b){
            uto.setMsg("数据库异常");
            uto.setStyle(-2);
        }
        uto.setMsg("驳回成功");
        uto.setStyle(1);
        return uto;
    }

}
