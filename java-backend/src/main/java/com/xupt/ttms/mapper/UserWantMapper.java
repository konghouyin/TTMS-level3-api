package com.xupt.ttms.mapper;

import com.xupt.ttms.model.UserWant;
import com.xupt.ttms.model.UserWantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserWantMapper {
    long countByExample(UserWantExample example);

    int deleteByExample(UserWantExample example);

    int deleteByPrimaryKey(Integer userwantId);

    int insert(UserWant record);

    int insertSelective(UserWant record);

    List<UserWant> selectByExample(UserWantExample example);

    UserWant selectByPrimaryKey(Integer userwantId);

    int updateByExampleSelective(@Param("record") UserWant record, @Param("example") UserWantExample example);

    int updateByExample(@Param("record") UserWant record, @Param("example") UserWantExample example);

    int updateByPrimaryKeySelective(UserWant record);

    int updateByPrimaryKey(UserWant record);
}