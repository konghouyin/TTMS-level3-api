package com.xupt.ttms.Service;

import com.xupt.ttms.mapper.ReportTypeMapper;
import com.xupt.ttms.model.ReportType;
import com.xupt.ttms.model.ReportTypeEnum;
import com.xupt.ttms.model.ReportTypeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportTypeService {
    @Autowired
    ReportTypeMapper reportTypeMapper;

    public int reportTypeAdd(ReportType type){
        int insert = reportTypeMapper.insert(type);
        if(0 == insert){
            return 0;
        }
        return 1;
    }

    public int updateReportType(ReportType type) {
        ReportTypeExample example = new ReportTypeExample();
        example.createCriteria().andReporttypeNameEqualTo(type.getReporttypeName());

        ReportType type1 = new ReportType();
        short status= (short) ReportTypeEnum.DELED.getType();
        type1.setReporttypeStatus(status);
        int i = reportTypeMapper.updateByExampleSelective(type1, example);
        if(i==0){
            return 0;
        }
        return 1;
    }

    public List<ReportType> getAll(){
        ReportTypeExample example = new ReportTypeExample();
        example.createCriteria().andReporttypeIdIsNotNull();

        List<ReportType> reportTypes = reportTypeMapper.selectByExample(example);
        return reportTypes;
    }
}
