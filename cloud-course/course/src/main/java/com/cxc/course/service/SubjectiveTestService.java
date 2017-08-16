package com.cxc.course.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cxc.course.mapper.SubjectiveTestMapper;
import com.cxc.course.model.SubjectiveTest;
import com.cxc.course.param.SubjectiveTestModifyParam;
import com.cxc.course.param.SubjectiveTestParam;
import com.cxc.util.DateUtil;
import com.cxc.util.ParamUtil;
import com.cxc.util.PropertyUtil;
import com.cxc.util.ResultUtil;

@Service
public class SubjectiveTestService {
	@Resource
	private SubjectiveTestMapper subjectiveTestMapper;
	
	public Object subjectiveTest(Long questionId) throws Exception {
		SubjectiveTest subjectiveTest = subjectiveTestMapper.selectByPrimaryKey(questionId);
		if (subjectiveTest != null) return subjectiveTest;
		return ResultUtil.NO_DATA_ERROR;
	}
	
	public Object subjectiveTestDelete(Long questionId) throws Exception {
		if (subjectiveTestMapper.deleteByPrimaryKey(questionId) == 1) {
			return ResultUtil.EMPTY_RESULT;
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	public Object subjectiveTest(SubjectiveTestParam param, Long userId) throws Exception {
		if (!ParamUtil.checkParamValid(param, null)) {
			return ResultUtil.PARAM_ERROR;
		}
		SubjectiveTest subjectiveTest = new SubjectiveTest();
		PropertyUtil.copy(param, subjectiveTest);
		
		if (subjectiveTest.getReferenceMaterial() == null) {
			subjectiveTest.setReferenceMaterial("");
		}		
		if (subjectiveTest.getSn() == null) {
			subjectiveTest.setSn(DateUtil.current());
		}
		if (subjectiveTest.getCommentOn() == null) {
			subjectiveTest.setCommentOn("");
		}
		subjectiveTest.setCreated(DateUtil.current());
		subjectiveTest.setUpdateUserId(userId);
		subjectiveTest.setSn(DateUtil.current());
		
		if (subjectiveTestMapper.insertSelective(subjectiveTest) == 1) {
			return subjectiveTestMapper.selectByPrimaryKey(subjectiveTest.getQuestionId());
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	public Object subjectiveTest(Long questionId, SubjectiveTestModifyParam param, Long userId)  throws Exception {
		if (!ParamUtil.checkParamValid(param, null) || questionId <= 0) {
			return ResultUtil.PARAM_ERROR;
		}
		SubjectiveTest subjectiveTest = new SubjectiveTest();
		PropertyUtil.copy(param, subjectiveTest);
		subjectiveTest.setQuestionId(questionId);
		subjectiveTest.setUpdated(DateUtil.current());
		subjectiveTest.setUpdateUserId(userId);
		
		if (subjectiveTestMapper.updateByPrimaryKeySelective(subjectiveTest) == 1) {
			return subjectiveTestMapper.selectByPrimaryKey(questionId);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
}
