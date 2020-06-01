package com.xupt.ttms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xupt.ttms.Service.ReportTypeService;
import com.xupt.ttms.dto.TransDTO;
import com.xupt.ttms.dto.returnDTO;
import com.xupt.ttms.dto.returnUTO;
import com.xupt.ttms.enums.returnType;
import com.xupt.ttms.model.ReportType;
import com.xupt.ttms.model.ReportTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("reportType")
public class ReportTypeController {

    @Autowired
    ReportTypeService service;

    @PostMapping("/add")
    public returnUTO addReportType(@RequestBody String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TransDTO transDTO = mapper.readValue(json, TransDTO.class);
        ReportType type = mapper.convertValue(transDTO.getData(), ReportType.class);
        short status= (short) ReportTypeEnum.WELL.getType();
        type.setReporttypeStatus(status);

        returnUTO uto = new returnUTO();
        int i = service.reportTypeAdd(type);
        if(i==0){
            uto.setStyle(returnType.DATABASEERR.getStyle());
            uto.setMsg(returnType.DATABASEERR.getMsg());
        }else if(i==1){
            uto.setStyle(returnType.SUCCESS.getStyle());
            uto.setMsg(returnType.SUCCESS.getMsg());
        }else if (i==2){
            uto.setMsg("覆盖成功");
            uto.setStyle(1);
        }else{
            uto.setMsg("已添加过");
            uto.setStyle(0);
        }


        return uto;
    }

    @PostMapping("/del")
    public returnUTO updateReportType(@RequestBody String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TransDTO transDTO = mapper.readValue(json, TransDTO.class);
        ReportType data = mapper.convertValue(transDTO.getData(), ReportType.class);
        int i = service.updateReportType(data);
        returnUTO uto = new returnUTO();
        if(i==0){
            uto.setStyle(0);
            uto.setMsg("未找到指定id");
        }else {
            uto.setStyle(returnType.SUCCESS.getStyle());
            uto.setMsg("删除"+returnType.SUCCESS.getMsg());
        }
        return uto;
    }

    @PostMapping("/all")
    public Object allReportType(){
        List<ReportType> all;
        try{
             all = service.getAll();
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
