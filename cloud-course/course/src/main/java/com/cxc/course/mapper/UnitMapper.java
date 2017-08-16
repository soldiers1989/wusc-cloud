package com.cxc.course.mapper;

import com.cxc.course.model.Unit;
import com.cxc.course.model.UnitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UnitMapper {
    int countByExample(UnitExample example);

    int deleteByExample(UnitExample example);

    int deleteByPrimaryKey(Long unitId);

    int insert(Unit record);

    int insertSelective(Unit record);

    List<Unit> selectByExample(UnitExample example);

    Unit selectByPrimaryKey(Long unitId);

    int updateByExampleSelective(@Param("record") Unit record, @Param("example") UnitExample example);

    int updateByExample(@Param("record") Unit record, @Param("example") UnitExample example);

    int updateByPrimaryKeySelective(Unit record);

    int updateByPrimaryKey(Unit record);
}