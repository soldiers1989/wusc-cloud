package com.cxc.chat.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.cxc.chat.model.UserRelation;
import com.cxc.chat.model.UserRelationKey;

public interface UserRelationMapper {
    int deleteByPrimaryKey(UserRelationKey key);

    int insert(UserRelation record);

    int insertSelective(UserRelation record);

    UserRelation selectByPrimaryKey(UserRelationKey key);

    int updateByPrimaryKeySelective(UserRelation record);

    int updateByPrimaryKey(UserRelation record);
    
    List<UserRelation> selectByUserIdAndType(@Param("userId") Long userId, @Param("type") Byte type);
    
    List<UserRelation> selectByAnotherUserIdAndType(@Param("anotherUserId") Long anotherUserId, @Param("type") Byte type);
    
    List<UserRelation> selectAllByUserIdAndType(@Param("userId") Long userId, @Param("type") Byte type);
    
    Set<Long> selectFriendIdByIds(@Param("userId") Long userId, @Param("userIds") List<Long> userIds, @Param("type") Byte type);
}