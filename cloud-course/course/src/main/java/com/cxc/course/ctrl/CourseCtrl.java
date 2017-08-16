package com.cxc.course.ctrl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxc.course.model.CourseExample;
import com.cxc.course.model.Learning;
import com.cxc.course.model.CourseExample.Criteria;
import com.cxc.course.model.PartExample;
import com.cxc.auth.AuthRequired;
import com.cxc.auth.RoleType;
import com.cxc.course.model.Course;
import com.cxc.course.model.CourseCommentExample;
import com.cxc.course.param.CourseModifyParam;
import com.cxc.course.param.CourseParam;
import com.cxc.course.ret.CourseContentRet;
import com.cxc.course.service.ChapterService;
import com.cxc.course.service.CourseCommentService;
import com.cxc.course.service.CourseService;
import com.cxc.course.service.LearningAccessService;
import com.cxc.course.service.PartService;
import com.cxc.course.service.SectionService;
import com.cxc.course.service.UnitService;
import com.cxc.course.service.UserAccessService;
import com.cxc.util.ResultUtil;
import com.cxc.vo.CourseCommentListData;
import com.cxc.vo.CourseListData;
import com.cxc.vo.LearningCourse;
import com.cxc.vo.LearningCourseListData;
import com.cxc.vo.PartListData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(value="courses", headers="Accept=application/json; version=1.0")
public class CourseCtrl {

	private static final Logger log = LoggerFactory.getLogger(CourseCtrl.class);
	
	@Resource
	private CourseService courseService;
	@Resource
	private ChapterService chapterService;
	@Resource
	private SectionService sectionService;
	@Resource
	private UnitService unitService;
	@Resource
	private PartService partService;
	@Resource
	private LearningAccessService learningAccessService;
	@Resource
	private CourseCommentService courseCommentService;
	@Resource
	private UserAccessService userAccessService;
	
	@ApiOperation(value="根据{course_id}获取课程", response=Course.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="{course_id}", method=RequestMethod.GET)
	public Object courses(@PathVariable("course_id") Long courseId) {
		try {
			return courseService.course(courseId);
		} catch (Exception e) {
			log.error("CourseCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="根据课程分类，讲师ID，最热，最新，课程名，收藏，参与情况获取符合条件的所有课程", response=CourseListData.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(method=RequestMethod.GET)
	public Object getCourses(@ApiIgnore @RequestHeader(value="user_id", required=false) Long userId,Boolean isCollection,Boolean isJoin,Boolean clickRate,Boolean created,String courseName, @RequestParam(value="offset", required=false) Integer offset,@RequestParam(required=false) Integer categoryId,@RequestParam(required=false)Long tutorId) {
				
		CourseExample courseExample=new CourseExample();

		Criteria criteria = courseExample.createCriteria(); 
		
		if (categoryId!=null) {
			criteria.andCategoryIdEqualTo(categoryId);
		}
		
		if (isCollection!=null) {
			if(isCollection){
				if (userId != null) {
					List<Long> collectedCourseIdList=getCollectedLearningIdList(getCollectedLearningList(userId));
					if(collectedCourseIdList.size()>0){
						criteria.andCourseIdIn(collectedCourseIdList);
					}
					else{
						return new CourseListData();
					}
				}
			}
		}
		if (isJoin!=null && isJoin && userId != null) {
				List<Long> joinedCourseIdList=getJoinedLearningIdList(getJoinedLearningList(userId));
				if(joinedCourseIdList.size()>0){
					criteria.andCourseIdIn(joinedCourseIdList);
				}
				else{
					return new CourseListData();
				}
		}
		
		if (courseName!=null) {
			criteria.andCourseNameLike("%"+courseName+"%");
		}
		
		if (clickRate!=null) {
			if(clickRate){
				courseExample.setOrderByClause("click_rate DESC");
			}
			else{
				courseExample.setOrderByClause("click_rate asc");
			}
		}
		if (created!=null) {
			if(created){
				courseExample.setOrderByClause("created DESC");
			}
			else{
				courseExample.setOrderByClause("created asc");
			}
		}
		
		try {
			//CourseListData wrapDatas = new CourseListData(courseService.selectCourses(courseExample, offset));
			Map<String, Object> mapData = courseService.getCourses(courseExample, offset);
			if(tutorId != null){
				List<Course> lstCourse = new ArrayList<Course>();
				((List<Course>) mapData.get("data")).forEach(course->{
					if (Arrays.asList(course.getTutorId().split(",")).contains(tutorId.toString())){
						lstCourse.add(course);
					}
				});
				mapData.put("data", lstCourse);
			}
			
			return mapData;
		} catch (Exception e) {
			log.error("CourseCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="页面使用的获取用户参与的所有课程列表", response=LearningCourseListData.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="joinedCourses", method=RequestMethod.GET)
	public Object getjoinedCourses(@ApiIgnore @RequestHeader("user_id") Long userId, @RequestParam(value="offset", required=false) Integer offset) {
				
		try {
			//User user=userAccessService.getUserInfo(userId);
			List<LearningCourse> learningCourseList=new ArrayList<LearningCourse>();
			List<Learning> joinedCourseLearningList=getJoinedLearningList(userId);
			
			CourseExample courseExample=new CourseExample();
			Criteria criteria = courseExample.createCriteria();
			List<Long> ids = getJoinedLearningIdList(joinedCourseLearningList);
			if (ids != null && !ids.isEmpty()) {
				criteria.andCourseIdIn(getJoinedLearningIdList(joinedCourseLearningList));
				List<Course> joinedCourseList=courseService.selectCourses(courseExample);
				for (Course course : joinedCourseList) {
					LearningCourse learningCourse=new LearningCourse();
					learningCourse.setCourseId(course.getCourseId());
					learningCourse.setCourseName(course.getCourseName());
					learningCourse.setPictureUrl(course.getPictureUrl());
					learningCourse.setAttendanceGrade(course.getAttendanceGrade());
					learningCourse.setExercisesGrade(course.getExercisesGrade());
					learningCourse.setExamineGrade(course.getExamineGrade());
					learningCourse.setPassingGrade(course.getPassingGrade());
					learningCourse.setLearningTargetNumber(course.getLearningTargetNumber());
					learningCourse.setSn(course.getSn());
					for (Learning learning : joinedCourseLearningList) {
						if(learning.getCourseId().longValue()==course.getCourseId().longValue()){
							learningCourse.setLearningId(learning.getLearningId());
							learningCourse.setIsCollection(learning.getIsCollection());
							learningCourse.setIsJoin(learning.getIsJoin());
							learningCourse.setFavoritesId(learning.getFavoritesId());
							learningCourse.setStatus(learning.getStatus());
							learningCourse.setProgress(learning.getProgress());
							learningCourse.setGrade(learning.getGrade());
							learningCourse.setEvaluate(learning.getEvaluate());
							learningCourse.setConfCredit(learning.getConfCredit());
						}
					}
					learningCourse.setSingInNum((short)Math.round((float)learningCourse.getProgress()/100f*(float)learningCourse.getLearningTargetNumber()));
					learningCourseList.add(learningCourse);
				}
			}
			return new LearningCourseListData(learningCourseList);
		} catch (Exception e) {
			log.error("CourseCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="页面使用的获取用户收藏的所有课程列表", response=LearningCourseListData.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="collectedCourses", method=RequestMethod.GET)
	public Object getCollectedCourses(@ApiIgnore @RequestHeader("user_id") Long userId, @RequestParam(value="offset", required=false) Integer offset) {
				
		try {
			//User user=userAccessService.getUserInfo(userId);
			List<LearningCourse> learningCourseList=new ArrayList<LearningCourse>();
			List<Learning> collectedCourseLearningList=getCollectedLearningList(userId);
			
			List<Long> ids = getCollectedLearningIdList(collectedCourseLearningList);
			if (ids != null && !ids.isEmpty()) {
				CourseExample courseExample=new CourseExample();
				Criteria criteria = courseExample.createCriteria();
				criteria.andCourseIdIn(ids);
				List<Course> collectedCourseList=courseService.selectCourses(courseExample);
				for (Course course : collectedCourseList) {
					LearningCourse learningCourse=new LearningCourse();
					learningCourse.setCourseId(course.getCourseId());
					learningCourse.setCourseName(course.getCourseName());
					learningCourse.setPictureUrl(course.getPictureUrl());
					learningCourse.setAttendanceGrade(course.getAttendanceGrade());
					learningCourse.setExercisesGrade(course.getExercisesGrade());
					learningCourse.setExamineGrade(course.getExamineGrade());
					learningCourse.setPassingGrade(course.getPassingGrade());
					learningCourse.setLearningTargetNumber(course.getLearningTargetNumber());
					learningCourse.setSn(course.getSn());
					for (Learning learning : collectedCourseLearningList) {
						if(learning.getCourseId().longValue()==course.getCourseId().longValue()){
							learningCourse.setLearningId(learning.getLearningId());
							learningCourse.setIsCollection(learning.getIsCollection());
							learningCourse.setIsJoin(learning.getIsJoin());
							learningCourse.setFavoritesId(learning.getFavoritesId());
							learningCourse.setStatus(learning.getStatus());
							learningCourse.setProgress(learning.getProgress());
							learningCourse.setGrade(learning.getGrade());
							learningCourse.setEvaluate(learning.getEvaluate());
							learningCourse.setConfCredit(learning.getConfCredit());
						}
					}
					learningCourse.setSingInNum((short)Math.round(learningCourse.getProgress()/100*learningCourse.getLearningTargetNumber()));
					learningCourseList.add(learningCourse);
				}
			}

			return new LearningCourseListData(learningCourseList);
		} catch (Exception e) {
			log.error("CourseCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="根据{course_id}删除课程，接口仅开放给运营用户adminUser", response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(path="{course_id}", method=RequestMethod.DELETE)
	@AuthRequired(role=RoleType.manager)
	public Object coursesDelete(@PathVariable("course_id") Long courseId) {
		try {
			return courseService.courseDelete(courseId);
		} catch (Exception e) {
			log.error("CourseCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="新增课程，接口仅开放给运营用户adminUser", response=Course.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(method=RequestMethod.POST)
	@AuthRequired(role=RoleType.manager)
	public Object coursesPost(@RequestBody CourseParam body, @ApiIgnore @RequestHeader("admin_user_id") Long userId) {
		try {
			return courseService.course(body, userId);
		} catch (Exception e) {
			log.error("CourseCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="修改课程，接口仅开放给运营用户adminUser", response=Course.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(path="{course_id}", method=RequestMethod.PUT)
	@AuthRequired(role=RoleType.manager)
	public Object coursesPut(@PathVariable("course_id") Long courseId,  @RequestBody CourseModifyParam body, @ApiIgnore @RequestHeader("admin_user_id") Long userId) {
		try {
			return courseService.course(courseId, body, userId);
		} catch (Exception e) {
			log.error("CourseCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="课程参与人数加一", response=Boolean.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(path="/{course_id}/participantsNumService", method=RequestMethod.GET)
	public Object participantsNumPlus(@PathVariable("course_id") Long courseId) {
		try {
			return courseService.recordParticipantsNum(courseId);
		} catch (Exception e) {
			log.error("CourseCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}

	public List<Learning> getJoinedLearningList(Long userId) {
		try {
			return learningAccessService.getJoinedCourseLearningList(userId).getData();
		} catch (Exception e) {
			log.error("CourseCtrl", e);
		}
		return null;
	}
	
	public List<Long> getJoinedLearningIdList(List<Learning> joinedLearningList) {
		try {
			List<Long> joinedLearningIdList=new ArrayList<Long>();
			for (Learning learning : joinedLearningList) {
				joinedLearningIdList.add(learning.getCourseId());
			}
			return joinedLearningIdList;
		} catch (Exception e) {
			log.error("CourseCtrl", e);
		}
		return null;
	}
	
	public List<Learning> getCollectedLearningList(Long userId) {
		try {
			return learningAccessService.getCollectedCourseLearningList(userId).getData();
		} catch (Exception e) {
			log.error("CourseCtrl", e);
		}
		return null;
	}
	
	public List<Long> getCollectedLearningIdList(List<Learning> collectedLearningList) {
		try {
			List<Long> collectedLearningIdList=new ArrayList<Long>();
			for (Learning learning : collectedLearningList) {
				collectedLearningIdList.add(learning.getCourseId());
			}
			return collectedLearningIdList;
		} catch (Exception e) {
			log.error("CourseCtrl", e);
		}
		return null;
	}

	@ApiOperation(value="根据{course_id}获取课程评论", response=CourseCommentListData.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="{course_id}/courseComments", method=RequestMethod.GET)
	public Object courseComments(@PathVariable("course_id") Long courseId, @RequestParam(value="offset", required=false) Integer offset) {
		CourseCommentExample courseCommentExample=new CourseCommentExample();
		CourseCommentExample.Criteria criteria = courseCommentExample.createCriteria(); 
		criteria.andCourseIdEqualTo(courseId);
		try {
			return new CourseCommentListData(courseCommentService.selectCourseComments(courseCommentExample, offset));
		} catch (Exception e) {
			log.error("CourseCommentCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="根据{course_id}获取所有parts", response=PartListData.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="{course_id}/parts", method=RequestMethod.GET)
	public Object getPartList(@PathVariable("course_id") Long courseId) {
		PartExample partExample=new PartExample();
		PartExample.Criteria criteria = partExample.createCriteria(); 
		criteria.andCourseIdEqualTo(courseId);
		try {
			return new PartListData(partService.selectPartList(partExample));
		} catch (Exception e) {
			log.error("CourseCommentCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="根据{course_id}获取课程详情（admin用户使用）", response=CourseContentRet.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(path="{course_id}/content", method=RequestMethod.GET)
	@AuthRequired(role=RoleType.manager)
	public Object coursesDetail(@PathVariable("course_id") Long courseId) {
		try {
			return courseService.courseContent(courseId);
		} catch (Exception e) {
			log.error("CourseCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
}
