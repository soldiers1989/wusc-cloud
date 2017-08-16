package com.cxc.video.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cxc.video.model.AliVideo;

public interface AliVideoMapper {
    int deleteByPrimaryKey(String videoId);

    int insert(AliVideo record);

    int insertSelective(AliVideo record);

    AliVideo selectByPrimaryKey(String videoId);
    
    @Select("select (exists (select 1 from ali_video where video_id = #{videoId})) as result")
    boolean existPrimaryKey(@Param("videoId") String videoId);

    int updateByPrimaryKeySelective(AliVideo record);

    int updateByPrimaryKey(AliVideo record);
}