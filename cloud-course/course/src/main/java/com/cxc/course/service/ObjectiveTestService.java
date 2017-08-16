package com.cxc.course.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cxc.course.mapper.ObjectiveTestMapper;
import com.cxc.course.model.ObjectiveTest;
import com.cxc.course.model.ObjectiveTestExample;
import com.cxc.course.param.ObjectiveTestModifyParam;
import com.cxc.course.param.ObjectiveTestParam;
import com.cxc.util.DateUtil;
import com.cxc.util.ParamUtil;
import com.cxc.util.PropertyUtil;
import com.cxc.util.ResultUtil;

@Service
public class ObjectiveTestService {
	@Resource
	private ObjectiveTestMapper objectiveTestMapper;
	
	public Object objectiveTest(Long questionId) throws Exception {
		ObjectiveTest objectiveTest = objectiveTestMapper.selectByPrimaryKey(questionId);
		if (objectiveTest != null) return objectiveTest;
		return ResultUtil.NO_DATA_ERROR;
	}
	
	public List<ObjectiveTest> selectObjectiveTest(ObjectiveTestExample objectiveTestExample) throws Exception {
        return objectiveTestMapper.selectByExample(objectiveTestExample);
    }
	
	public Object objectiveTestDelete(Long questionId) throws Exception {
		if (objectiveTestMapper.deleteByPrimaryKey(questionId) == 1) {
			return ResultUtil.EMPTY_RESULT;
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	public Object objectiveTest(ObjectiveTestParam param, Long userId) throws Exception {
		if (!ParamUtil.checkParamValid(param, null)) {
			return ResultUtil.PARAM_ERROR;
		}
		ObjectiveTest objectiveTest = new ObjectiveTest();
		PropertyUtil.copy(param, objectiveTest);
		
		if (objectiveTest.getQuestionType() == null) {
			objectiveTest.setQuestionType((short) 0);
		}	
		if (objectiveTest.getCommentOn() == null) {
			objectiveTest.setCommentOn("");
		}
		objectiveTest.setCreated(DateUtil.current());
		objectiveTest.setUpdateUserId(userId);
		objectiveTest.setSn(DateUtil.current());
		
		if (objectiveTestMapper.insertSelective(objectiveTest) == 1) {
			return objectiveTestMapper.selectByPrimaryKey(objectiveTest.getQuestionId());
		}
		
		return ResultUtil.SYSTEM_ERROR;
	}
	
	public Object objectiveTest(Long questionId, ObjectiveTestModifyParam param, Long userId) throws Exception {
		if (!ParamUtil.checkParamValid(param, null) || questionId <= 0) {
			return ResultUtil.PARAM_ERROR;
		}
		ObjectiveTest objectiveTest = new ObjectiveTest();
		PropertyUtil.copy(param, objectiveTest);
		objectiveTest.setQuestionId(questionId);
		objectiveTest.setUpdated(DateUtil.current());
		objectiveTest.setUpdateUserId(userId);
		
		if (objectiveTestMapper.updateByPrimaryKeySelective(objectiveTest) == 1) {
			return objectiveTestMapper.selectByPrimaryKey(questionId);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
}
