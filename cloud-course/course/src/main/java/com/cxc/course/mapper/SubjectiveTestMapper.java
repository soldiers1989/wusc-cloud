package com.cxc.course.mapper;

import com.cxc.course.model.SubjectiveTest;
import com.cxc.course.model.SubjectiveTestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubjectiveTestMapper {
    int countByExample(SubjectiveTestExample example);

    int deleteByExample(SubjectiveTestExample example);

    int deleteByPrimaryKey(Long questionId);

    int insert(SubjectiveTest record);

    int insertSelective(SubjectiveTest record);

    List<SubjectiveTest> selectByExample(SubjectiveTestExample example);

    SubjectiveTest selectByPrimaryKey(Long questionId);

    int updateByExampleSelective(@Param("record") SubjectiveTest record, @Param("example") SubjectiveTestExample example);

    int updateByExample(@Param("record") SubjectiveTest record, @Param("example") SubjectiveTestExample example);

    int updateByPrimaryKeySelective(SubjectiveTest record);

    int updateByPrimaryKey(SubjectiveTest record);
}