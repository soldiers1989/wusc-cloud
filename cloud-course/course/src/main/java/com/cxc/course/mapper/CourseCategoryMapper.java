package com.cxc.course.mapper;

import com.cxc.course.model.CourseCategory;
import com.cxc.course.model.CourseCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseCategoryMapper {
    int countByExample(CourseCategoryExample example);

    int deleteByExample(CourseCategoryExample example);

    int deleteByPrimaryKey(Integer categoryId);

    int insert(CourseCategory record);

    int insertSelective(CourseCategory record);

    List<CourseCategory> selectByExample(CourseCategoryExample example);

    CourseCategory selectByPrimaryKey(Integer categoryId);

    int updateByExampleSelective(@Param("record") CourseCategory record, @Param("example") CourseCategoryExample example);

    int updateByExample(@Param("record") CourseCategory record, @Param("example") CourseCategoryExample example);

    int updateByPrimaryKeySelective(CourseCategory record);

    int updateByPrimaryKey(CourseCategory record);
}