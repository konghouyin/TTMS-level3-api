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
        }else if(i==1){
            uto.setStyle(returnType.SUCCESS.getStyle());
            uto.setMsg(returnType.SUCCESS.getMsg());
        }else if(i==2){
            uto.setMsg("该评论已被覆盖");
            uto.setStyle(1);
        }else if(i==-3){
            uto.setMsg("您关于该电影的评论已被举报");
            uto.setStyle(0);
        }else {
            uto.setMsg("查无此电影，id无效");
            uto.setStyle(0);
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
        int b = service.delComment(comment);

        returnUTO uto = new returnUTO();
        if(b==-1){
            uto.setMsg("数据库异常");
            uto.setStyle(-2);
        }else if(b==0){
            uto.setMsg("删除成功");
            uto.setStyle(1);
        }else {
            uto.setMsg("评论已进行相关操作，无法删除");
            uto.setStyle(0);
        }

        return uto;
    }

    //驳回
    @PostMapping("/reject")
    public returnUTO rejComment(@RequestBody String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TransDTO dto = mapper.readValue(json,TransDTO.class);

        Comment comment = mapper.convertValue(dto.getData(),Comment.class);
        int b = service.rejectComment(comment);

        returnUTO uto = new returnUTO();
        if(b==-1){
            uto.setMsg("数据库异常");
            uto.setStyle(-2);
        }else if(b==0){
            uto.setMsg("驳回成功");
            uto.setStyle(1);
        }else {
            uto.setMsg("评论已删除");
            uto.setStyle(0);
        }

        return uto;
    }

}
