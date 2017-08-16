package com.cxc.course.mapper;

import com.cxc.course.model.ObjectiveTest;
import com.cxc.course.model.ObjectiveTestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ObjectiveTestMapper {
    int countByExample(ObjectiveTestExample example);

    int deleteByExample(ObjectiveTestExample example);

    int deleteByPrimaryKey(Long questionId);

    int insert(ObjectiveTest record);

    int insertSelective(ObjectiveTest record);

    List<ObjectiveTest> selectByExample(ObjectiveTestExample example);

    ObjectiveTest selectByPrimaryKey(Long questionId);

    int updateByExampleSelective(@Param("record") ObjectiveTest record, @Param("example") ObjectiveTestExample example);

    int updateByExample(@Param("record") ObjectiveTest record, @Param("example") ObjectiveTestExample example);

    int updateByPrimaryKeySelective(ObjectiveTest record);

    int updateByPrimaryKey(ObjectiveTest record);
}