package com.cxc.course.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cxc.course.model.CreditSetting;
import com.cxc.course.model.Learning;
import com.cxc.vo.LearningListData;

@Service
public class LearningAccessService{
	
	@Resource
	private LearningRemoteService learningRemoteService;

	public LearningListData getCollectedCourseLearningList(Long userId) {
		return learningRemoteService.getCollectedCourseLearningList(userId);
	}

	public LearningListData getJoinedCourseLearningList(Long userId) {
		return learningRemoteService.getJoinedCourseLearningList(userId);
	}

	public Learning getLearningByPrimaryKey(Long learningId) {
		return learningRemoteService.getLearningByPrimaryKey(learningId);
	}

	public Learning getLearning(Long userId, Long courseId) {
		return learningRemoteService.getLearning(userId, courseId);
	}

	public CreditSetting getCourseCredit(Long schoolId, Long courseId) {
		return learningRemoteService.getCourseCredit(schoolId, courseId);
	}
}
