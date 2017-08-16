package com.cxc.ms.service.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cxc.ms.service.mvc.model.User;
import com.cxc.ms.service.mvc.model.UserExample;
import com.cxc.ms.service.mvc.ret.UserSelf;

public interface UserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);
    
    List<UserSelf> selectByExample(UserExample example);

    User selectByPrimaryKey(Long userId);

    UserSelf selectUserSelfById(Long userId);
    
    User selectByPhone(String phone);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    @Select("select user_id from user where phone = #{phone}")
    Long selectUserIdByPhone(@Param("phone") String phone);
}