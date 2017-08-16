package com.cxc.system.mapper;

import com.cxc.system.model.SystemVersion;
import com.cxc.system.model.SystemVersionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemVersionMapper {
    int countByExample(SystemVersionExample example);

    int deleteByPrimaryKey(Long systemVersionId);

    int insert(SystemVersion record);

    int insertSelective(SystemVersion record);

    List<SystemVersion> selectByExample(SystemVersionExample example);

    SystemVersion selectByPrimaryKey(Long systemVersionId);

    int updateByExampleSelective(@Param("record") SystemVersion record, @Param("example") SystemVersionExample example);

    int updateByExample(@Param("record") SystemVersion record, @Param("example") SystemVersionExample example);

    int updateByPrimaryKeySelective(SystemVersion record);

    int updateByPrimaryKey(SystemVersion record);
}