package com.cxc.system.mapper;

import com.cxc.system.model.System;
import com.cxc.system.model.SystemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemMapper {
    int deleteByPrimaryKey(Long systemId);

    int insert(System record);

    int insertSelective(System record);

    List<System> selectByExample(SystemExample example);

    System selectByPrimaryKey(Long systemId);

    int updateByExampleSelective(@Param("record") System record, @Param("example") SystemExample example);

    int updateByExample(@Param("record") System record, @Param("example") SystemExample example);

    int updateByPrimaryKeySelective(System record);

    int updateByPrimaryKey(System record);
}