package com.cxc.course.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cxc.course.model.CreditSetting;
import com.cxc.course.model.Learning;
import com.cxc.vo.LearningListData;

@Service
public class LearningRemoteServiceFail implements LearningRemoteService {

	private static final Logger log = LoggerFactory.getLogger(LearningRemoteServiceFail.class);
	
	@Override
	public LearningListData getCollectedCourseLearningList(Long userId) {
		log.error("LearningRemoteServiceFail error! userId:{}", userId);
		return null;
	}

	@Override
	public LearningListData getJoinedCourseLearningList(Long userId) {
		log.error("LearningRemoteServiceFail error! userId:{}", userId);
		return null;
	}

	@Override
	public Learning getLearningByPrimaryKey(Long learningId) {
		log.error("LearningRemoteServiceFail error! learningId:{}", learningId);
		return null;
	}

	@Override
	public Learning getLearning(Long userId, Long courseId) {
		log.error("LearningRemoteServiceFail error! userId:{}, courseId:{}", userId, courseId);
		return null;
	}

	@Override
	public CreditSetting getCourseCredit(Long schoolId, Long courseId) {
		log.error("LearningRemoteServiceFail error! schoolId:{}, courseId:{}", schoolId, courseId);
		return null;
	}

}
