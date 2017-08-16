package com.cxc.course.mapper;

import com.cxc.course.model.Part;
import com.cxc.course.model.PartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PartMapper {
    int countByExample(PartExample example);

    int deleteByExample(PartExample example);

    int deleteByPrimaryKey(Long partId);

    int insert(Part record);

    int insertSelective(Part record);

    List<Part> selectByExample(PartExample example);

    Part selectByPrimaryKey(Long partId);

    int updateByExampleSelective(@Param("record") Part record, @Param("example") PartExample example);

    int updateByExample(@Param("record") Part record, @Param("example") PartExample example);

    int updateByPrimaryKeySelective(Part record);

    int updateByPrimaryKey(Part record);
}