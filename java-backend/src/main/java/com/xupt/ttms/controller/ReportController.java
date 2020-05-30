package com.xupt.ttms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xupt.ttms.Service.ReportService;
import com.xupt.ttms.dto.TransDTO;
import com.xupt.ttms.dto.returnUTO;
import com.xupt.ttms.enums.ReportEnum;
import com.xupt.ttms.enums.returnType;
import com.xupt.ttms.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("report")
public class ReportController {

    @Autowired
    ReportService service;
    @PostMapping("/add")
    public returnUTO reportAdd(@RequestBody String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TransDTO transDTO = mapper.readValue(json, TransDTO.class);


        returnUTO uto = new returnUTO();
        Report report = mapper.convertValue(transDTO.getData(), Report.class);
        short status = (short) ReportEnum.Processing.getStatus();//待审核
        int userId = transDTO.getUserInfo().getUser_id();
        report.setReportStatus(status);
        report.setUserId(userId);
        int i = service.reportAdd(report);
        if(i==0){
            uto.setStyle(returnType.DATABASEERR.getStyle());
            uto.setMsg(returnType.DATABASEERR.getMsg());
        }else if(i>=1){
            uto.setStyle(returnType.SUCCESS.getStyle());
            uto.setMsg(returnType.SUCCESS.getMsg());
        }else {
            uto.setMsg("该评论已举报");
            uto.setStyle(0);
        }
        return uto;
    }

}
