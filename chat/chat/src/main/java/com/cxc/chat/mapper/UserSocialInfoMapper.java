package com.cxc.chat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cxc.chat.model.UserSocialInfo;

public interface UserSocialInfoMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(UserSocialInfo record);

    int insertSelective(UserSocialInfo record);

    UserSocialInfo selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(UserSocialInfo record);

    int updateByPrimaryKey(UserSocialInfo record);
    
    Integer selectFriendsCountByUserId(@Param("userId") Long userId);
    
    int incFriendsCountPrimaryKey(@Param("userId") Long userId);
    
    int decFriendsCountPrimaryKey(@Param("userId") Long userId);
    
    List<UserSocialInfo> selectListByPrimaryKey(@Param("userId") List<Long> userId);
}