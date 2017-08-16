package com.cxc.course.mapper;

import com.cxc.course.model.Section;
import com.cxc.course.model.SectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SectionMapper {
    int countByExample(SectionExample example);

    int deleteByExample(SectionExample example);

    int deleteByPrimaryKey(Long sectionId);

    int insert(Section record);

    int insertSelective(Section record);

    List<Section> selectByExample(SectionExample example);

    Section selectByPrimaryKey(Long sectionId);

    int updateByExampleSelective(@Param("record") Section record, @Param("example") SectionExample example);

    int updateByExample(@Param("record") Section record, @Param("example") SectionExample example);

    int updateByPrimaryKeySelective(Section record);

    int updateByPrimaryKey(Section record);
}