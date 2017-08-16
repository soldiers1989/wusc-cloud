package com.cxc.course.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cxc.course.model.CreditSetting;
import com.cxc.course.model.Learning;
import com.cxc.vo.LearningListData;

@FeignClient(name = "learning", fallback=com.cxc.course.service.LearningRemoteServiceFail.class)
public interface LearningRemoteService {

	@RequestMapping(value="/learnings/collectServices", method=RequestMethod.GET)
	public LearningListData getCollectedCourseLearningList(@RequestHeader("user_id") Long userId);
	
	@RequestMapping(value="/learnings/joinServices", method=RequestMethod.GET)
	public LearningListData getJoinedCourseLearningList(@RequestHeader("user_id") Long userId);
	
	@RequestMapping(value="/learnings/{learning_id}", method=RequestMethod.GET)
	public Learning getLearningByPrimaryKey(@PathVariable("learning_id") Long learningId);
	
	@RequestMapping(value="/learnings", method=RequestMethod.GET)
	public Learning getLearning(@RequestParam("userId") Long userId, @RequestParam("courseId") Long courseId);
	
	@RequestMapping(value="/creditSettings", method=RequestMethod.GET)
	public CreditSetting getCourseCredit(@RequestParam("schoolId") Long schoolId, @RequestParam("courseId") Long courseId);
}
