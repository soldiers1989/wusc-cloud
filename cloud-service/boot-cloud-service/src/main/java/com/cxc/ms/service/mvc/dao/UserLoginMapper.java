package com.cxc.ms.service.mvc.dao;

import com.cxc.ms.service.mvc.model.UserLogin;

public interface UserLoginMapper {
    int deleteByPrimaryKey(Long loginId);

    int insert(UserLogin record);

    int insertSelective(UserLogin record);

    UserLogin selectByPrimaryKey(Long loginId);

    int updateByPrimaryKeySelective(UserLogin record);

    int updateByPrimaryKey(UserLogin record);
}