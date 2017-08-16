package com.cxc.course.mapper;

import com.cxc.course.model.CourseClass;
import com.cxc.course.model.CourseClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseClassMapper {
    int countByExample(CourseClassExample example);

    int deleteByExample(CourseClassExample example);

    int deleteByPrimaryKey(Integer classId);

    int insert(CourseClass record);

    int insertSelective(CourseClass record);

    List<CourseClass> selectByExample(CourseClassExample example);

    CourseClass selectByPrimaryKey(Integer classId);

    int updateByExampleSelective(@Param("record") CourseClass record, @Param("example") CourseClassExample example);

    int updateByExample(@Param("record") CourseClass record, @Param("example") CourseClassExample example);

    int updateByPrimaryKeySelective(CourseClass record);

    int updateByPrimaryKey(CourseClass record);
}