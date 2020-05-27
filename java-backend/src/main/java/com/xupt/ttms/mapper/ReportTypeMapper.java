package com.xupt.ttms.mapper;

import com.xupt.ttms.model.ReportType;
import com.xupt.ttms.model.ReportTypeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper

public interface ReportTypeMapper {
    long countByExample(ReportTypeExample example);

    int deleteByExample(ReportTypeExample example);

    int deleteByPrimaryKey(Integer reporttypeId);

    int insert(ReportType record);

    int insertSelective(ReportType record);

    List<ReportType> selectByExample(ReportTypeExample example);

    ReportType selectByPrimaryKey(Integer reporttypeId);

    int updateByExampleSelective(@Param("record") ReportType record, @Param("example") ReportTypeExample example);

    int updateByExample(@Param("record") ReportType record, @Param("example") ReportTypeExample example);

    int updateByPrimaryKeySelective(ReportType record);

    int updateByPrimaryKey(ReportType record);
}