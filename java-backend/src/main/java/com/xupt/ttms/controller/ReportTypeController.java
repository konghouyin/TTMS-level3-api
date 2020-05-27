package com.xupt.ttms.controller;

import com.xupt.ttms.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReportTypeController {

    @Autowired
    ReportService service;

    @PostMapping("/get")
    public void getAll(@RequestBody String json){

        System.out.println(json);
    }
}
