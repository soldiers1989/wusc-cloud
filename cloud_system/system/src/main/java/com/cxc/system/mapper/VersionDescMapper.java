package com.cxc.system.mapper;

import com.cxc.system.model.VersionDesc;
import com.cxc.system.model.VersionDescExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VersionDescMapper {
    int countByExample(VersionDescExample example);

    int deleteByPrimaryKey(Long versionDescId);

    int insert(VersionDesc record);

    int insertSelective(VersionDesc record);

    List<VersionDesc> selectByExample(VersionDescExample example);

    VersionDesc selectByPrimaryKey(Long versionDescId);

    int updateByExampleSelective(@Param("record") VersionDesc record, @Param("example") VersionDescExample example);

    int updateByExample(@Param("record") VersionDesc record, @Param("example") VersionDescExample example);

    int updateByPrimaryKeySelective(VersionDesc record);

    int updateByPrimaryKey(VersionDesc record);
}