package com.cxc.ms.service.mvc.model;

import com.cxc.ms.service.mvc.model.UserSuggestion;

public interface UserSuggestionMapper {
    int deleteByPrimaryKey(Long userSuggestionId);

    int insert(UserSuggestion record);

    int insertSelective(UserSuggestion record);

    UserSuggestion selectByPrimaryKey(Long userSuggestionId);

    int updateByPrimaryKeySelective(UserSuggestion record);

    int updateByPrimaryKey(UserSuggestion record);
}