package com.cxc.ms.service.mvc.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cxc.ms.service.mvc.model.Session;

public interface SessionMapper {
    int deleteByPrimaryKey(Long sessionId);

    int insert(Session record);

    int insertSelective(Session record);

    Session selectByPrimaryKey(Long sessionId);

    int updateByPrimaryKeySelective(Session record);

    int updateByPrimaryKey(Session record);
    
    @Select("select session_id from session where token=#{token} and user_id=#{userId}")
    Long selectByUserIdAndToken(@Param("token") String token, @Param("userId")Long userId);
}