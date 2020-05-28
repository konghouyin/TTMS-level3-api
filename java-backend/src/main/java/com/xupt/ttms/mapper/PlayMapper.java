package com.xupt.ttms.mapper;

import com.xupt.ttms.model.Play;
import com.xupt.ttms.model.PlayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlayMapper {
    long countByExample(PlayExample example);

    int deleteByExample(PlayExample example);

    int deleteByPrimaryKey(Integer playId);

    int insert(Play record);

    int insertSelective(Play record);

    List<Play> selectByExampleWithBLOBs(PlayExample example);

    List<Play> selectByExample(PlayExample example);

    Play selectByPrimaryKey(Integer playId);

    int updateByExampleSelective(@Param("record") Play record, @Param("example") PlayExample example);

    int updateByExampleWithBLOBs(@Param("record") Play record, @Param("example") PlayExample example);

    int updateByExample(@Param("record") Play record, @Param("example") PlayExample example);

    int updateByPrimaryKeySelective(Play record);

    int updateByPrimaryKeyWithBLOBs(Play record);

    int updateByPrimaryKey(Play record);
}