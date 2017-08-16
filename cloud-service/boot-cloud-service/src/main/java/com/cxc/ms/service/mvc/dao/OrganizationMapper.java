package com.cxc.ms.service.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cxc.ms.service.mvc.model.Organization;
import com.cxc.ms.service.mvc.model.OrganizationExample;

public interface OrganizationMapper {
    int countByExample(OrganizationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Organization record);

    int insertSelective(Organization record);

    List<Organization> selectByExample(OrganizationExample example);

    Organization selectByPrimaryKey(Long id);
    
    List<Organization> selectByOrgName(@Param("name") String name);

    int updateByExampleSelective(@Param("record") Organization record, @Param("example") OrganizationExample example);

    int updateByExample(@Param("record") Organization record, @Param("example") OrganizationExample example);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);
}