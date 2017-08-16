package com.cxc.ms.service.mvc.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cxc.ms.service.mvc.dao.UserSuggestionMapper;
import com.cxc.ms.service.mvc.model.UserSuggestion;
import com.cxc.util.DateUtil;
import com.cxc.util.ParamUtil;
import com.cxc.util.ResultUtil;

@Service
public class SuggestService {

	@Resource
	private UserSuggestionMapper userSuggestionMapper;
	
	/**
	 * 插入建议
	 * @param suggestion
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public Object suggest(UserSuggestion suggestion, Long userId) throws Exception {
		suggestion.setUserId(userId);
		if (!ParamUtil.checkParamValid(suggestion, null)) {
			return ResultUtil.PARAM_ERROR;
		}
		suggestion.setSuggestionType(UserSuggestion.TYPE_COMMON);
		suggestion.setSubmitTime(DateUtil.current());
		if (userSuggestionMapper.insertSelective(suggestion) == 1) {
			return ResultUtil.EMPTY_RESULT;
		}
		
		return ResultUtil.SYSTEM_ERROR;
	}
}
