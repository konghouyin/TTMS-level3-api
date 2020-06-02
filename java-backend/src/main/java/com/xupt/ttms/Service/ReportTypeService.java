package com.xupt.ttms.Service;

import com.xupt.ttms.mapper.ReportTypeMapper;
import com.xupt.ttms.model.Report;
import com.xupt.ttms.model.ReportType;
import com.xupt.ttms.model.ReportTypeEnum;
import com.xupt.ttms.model.ReportTypeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReportTypeService {
    @Autowired
    ReportTypeMapper reportTypeMapper;

    public int reportTypeAdd(ReportType type){
        ReportTypeExample example = new ReportTypeExample();
        example.createCriteria().andReporttypeNameEqualTo(type.getReporttypeName());
        List<ReportType> select = reportTypeMapper.selectByExample(example);
        if(select.size()>0 && select.get(0).getReporttypeStatus()!=1){
            ReportType type1 = new ReportType();
            type1.setReporttypeStatus((short) ReportTypeEnum.WELL.getType());

            ReportTypeExample example1 = new ReportTypeExample();
            example1.createCriteria().andReporttypeNameEqualTo(type.getReporttypeName());
            reportTypeMapper.updateByExampleSelective(type1,example1);

            return 2;
        }else if (select.size()>0 && select.get(0).getReporttypeStatus()==1){
            return 3;
        }
        int insert = reportTypeMapper.insert(type);
        if(0 == insert){
            return 0;
        }
        return 1;
    }

    @Transactional
    public int updateReportType(ReportType type) {
        ReportTypeExample example = new ReportTypeExample();
        example.createCriteria().andReporttypeIdEqualTo(type.getReporttypeId());

        ReportType type1 = new ReportType();
        short status= (short) ReportTypeEnum.DELED.getType();
        type1.setReporttypeName(reportTypeMapper.selectByPrimaryKey(type.getReporttypeId()).getReporttypeName());
        //type1.setReporttypeName(type.getReporttypeName());
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
