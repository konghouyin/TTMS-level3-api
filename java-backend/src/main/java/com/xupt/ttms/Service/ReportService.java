package com.xupt.ttms.Service;

import com.xupt.ttms.mapper.ReportTypeMapper;
import com.xupt.ttms.model.ReportType;
import com.xupt.ttms.model.ReportTypeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    @Autowired
    ReportTypeMapper reportTypeMapper;


    public ReportType getAll(){
        ReportType reportType = reportTypeMapper.selectByPrimaryKey(1);
        System.out.println(reportType);
        return reportType;
    }

    public int reportTypeAdd(){
        return 1;
    }
}
