package com.cxc.course.mapper;

import com.cxc.course.model.Tutor;
import com.cxc.course.model.TutorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TutorMapper {
    int countByExample(TutorExample example);

    int deleteByExample(TutorExample example);

    int deleteByPrimaryKey(Long tutorId);

    int insert(Tutor record);

    int insertSelective(Tutor record);

    List<Tutor> selectByExample(TutorExample example);

    Tutor selectByPrimaryKey(Long tutorId);

    int updateByExampleSelective(@Param("record") Tutor record, @Param("example") TutorExample example);

    int updateByExample(@Param("record") Tutor record, @Param("example") TutorExample example);

    int updateByPrimaryKeySelective(Tutor record);

    int updateByPrimaryKey(Tutor record);
}