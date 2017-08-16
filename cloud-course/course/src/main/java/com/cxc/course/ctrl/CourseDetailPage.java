package com.cxc.course.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxc.course.model.Chapter;
import com.cxc.course.model.ChapterExample;
import com.cxc.course.model.Course;
import com.cxc.course.model.CourseComment;
import com.cxc.course.model.CourseCommentExample;
import com.cxc.course.model.Learning;
import com.cxc.course.model.Part;
import com.cxc.course.model.PartExample;
import com.cxc.course.model.Section;
import com.cxc.course.model.SectionExample;
import com.cxc.course.model.Tutor;
import com.cxc.course.model.TutorExample;
import com.cxc.course.model.Unit;
import com.cxc.course.model.UnitExample;
import com.cxc.course.service.ChapterService;
import com.cxc.course.service.CourseCommentService;
import com.cxc.course.service.CourseService;
import com.cxc.course.service.LearningAccessService;
import com.cxc.course.service.PartService;
import com.cxc.course.service.SectionService;
import com.cxc.course.service.TutorService;
import com.cxc.course.service.UnitService;
import com.cxc.course.service.UserAccessService;
import com.cxc.course.model.LearningProgressRecordUnit;
import com.cxc.util.ResultUtil;
import com.cxc.vo.ChapterNode;
import com.cxc.vo.CourseDetail;
import com.cxc.vo.CourseDetailPageData;
import com.cxc.vo.PartNode;
import com.cxc.vo.SectionNode;
import com.cxc.vo.UnitNode;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(value="CourseDetailPageServices", headers="Accept=application/json; version=1.0")
public class CourseDetailPage {
	private static final Logger log = LoggerFactory.getLogger(CourseDetailPage.class);

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
	private TutorService tutorService;
	@Resource
	private CourseCommentService courseCommentService;
	@Resource
	private LearningAccessService learningAccessService;
	@Resource
	private UserAccessService userAccessService;
	
	//Course courseObj;
	//List<Chapter> chapterList;
	//List<Section> sectionList;
	//List<Unit> unitList;
	//List<Part> partList;
	//List<Tutor> tutorList;
	//List<CourseComment> courseCommentList;
	//List<LearningProgressRecordUnit> learningProgressRecordUnitList;
	//Learning learning;
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value="获取课程详情页所有数据", response=CourseDetailPageData.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="{course_id}", method=RequestMethod.GET)
	public Object getCourseDetailPageServices(@PathVariable("course_id") Long courseId, @ApiIgnore @RequestHeader("user_id") Long userId) {

		ChapterExample chapterExample=new ChapterExample();
		ChapterExample.Criteria chapterCriteria = chapterExample.createCriteria(); 
		chapterCriteria.andCourseIdEqualTo(courseId);
		
		SectionExample sectionExample=new SectionExample();
		SectionExample.Criteria sectionCriteria = sectionExample.createCriteria(); 
		sectionCriteria.andCourseIdEqualTo(courseId);
		
		UnitExample unitExample=new UnitExample();
		UnitExample.Criteria unitCriteria = unitExample.createCriteria(); 
		unitCriteria.andCourseIdEqualTo(courseId);
		
		PartExample partExample=new PartExample();
		PartExample.Criteria partCriteria = partExample.createCriteria(); 
		partCriteria.andCourseIdEqualTo(courseId);
		
		CourseDetailPageData courseDetailPageData=new CourseDetailPageData();
		try {
			CourseDetail courseDetail=new CourseDetail();
			//获取此课程相关的所有目录信息
			Course courseObj=(Course) courseService.course(courseId);
			List<Chapter> chapterList=chapterService.selectChapterList(chapterExample);
			List<Section> sectionList=sectionService.selectSectionList(sectionExample);
			List<Unit> unitList=unitService.selectUnitList(unitExample);
			List<Part> partList=partService.selectPartList(partExample);
			
			Learning learning =learningAccessService.getLearning(userId,courseObj.getCourseId());
			List<LearningProgressRecordUnit> learningProgressRecordUnitList = null;
			if(learning!=null){
				courseDetailPageData.setIsJoin(learning.getIsJoin());
				courseDetailPageData.setIsCollected(learning.getIsCollection());
				JSONArray jsonarray = JSONArray.fromObject(learning.getProgressRecord());    
				learningProgressRecordUnitList = (List<LearningProgressRecordUnit>)JSONArray.toCollection(jsonarray, LearningProgressRecordUnit.class);  
			}
			
			//重建课程结构
			if(!courseObj.getIsLeafNode()){
				//课程下有章，查找并挂载课程的章
				List<ChapterNode> chapterNodeList=new ArrayList<ChapterNode>();
				for (Chapter chapter : chapterList) {
					//处理每一章
					ChapterNode chapterNode=new ChapterNode();
					if(!chapter.getIsLeafNode()){
						//章下有节，查找并挂载章的节
						List<SectionNode> sectionNodeList=new ArrayList<SectionNode>();
						for (Section section : sectionList) {
							//处理每一节
							SectionNode sectionNode=new SectionNode();
							if(!section.getIsLeafNode()){
								//节下有单元，查找并挂载节的单元
								List<UnitNode> unitNodeList=new ArrayList<UnitNode>();
								for (Unit unit : unitList) {
									if(unit.getSectionId().longValue()==section.getSectionId().longValue()){
										if(unit.getIsLeafNode()){
											//必定是真，将对应的部分添加到单元
											//处理每个单元
											UnitNode unitNode=new UnitNode();
											//将part挂入对应的单元
											List<PartNode> targetPartList=new ArrayList<>();
											for (Part part : partList) {
												if(unit.getUnitId().longValue()==part.getUnitId().longValue()){
													targetPartList.add(getUnitNode(part, learningProgressRecordUnitList));
												}
											}	
											unitNode.setPartList(targetPartList);
											//unitNode.setUnitObj(unit);
											unitNode.setCourseId(unit.getCourseId());
											unitNode.setSectionId(unit.getSectionId());
											unitNode.setUnitId(unit.getUnitId());
											unitNode.setUnitName(unit.getUnitName());
											unitNode.setUnitType(unit.getUnitType());
											unitNode.setPictureUrl(unit.getPictureUrl());
											unitNode.setSn(unit.getSn());
											unitNode.setIsLeafNode(unit.getIsLeafNode());
											
											unitNodeList.add(unitNode);
										}
									}
								}//单元处理完
								sectionNode.setPartList(null);
								sectionNode.setUnitNodeList(unitNodeList);
							}
							else{
								//节下没有单元，将part挂入对应的节
								List<PartNode> targetPartList=new ArrayList<>();
								for (Part part : partList) {
									if(section.getSectionId().longValue()==part.getSectionId().longValue()){
										targetPartList.add(getUnitNode(part, learningProgressRecordUnitList));
									}
								}
								sectionNode.setPartList(targetPartList);
								sectionNode.setUnitNodeList(null);
							}
							//sectionNode.setSectionObj(section);
							sectionNode.setCourseId(section.getCourseId());
							sectionNode.setChapterId(section.getChapterId());
							sectionNode.setSectionId(section.getSectionId());
							sectionNode.setSectionName(section.getSectionName());
							sectionNode.setPictureUrl(section.getPictureUrl());
							sectionNode.setDepict(section.getDepict());
							sectionNode.setSn(section.getSn());
							sectionNode.setIsLeafNode(section.getIsLeafNode());
							sectionNodeList.add(sectionNode);
						}
						chapterNode.setPartList(null);
						chapterNode.setSectionNodeList(sectionNodeList);
						//chapterNodeList.add(chapterNode);
					}//章下有节，查找并挂载章的节
					else{
						//章下没有节，将part挂入对应的章
						List<PartNode> targetPartList=new ArrayList<>();
						for (Part part : partList) {
							if(chapter.getChapterId().longValue()==part.getChapterId().longValue()){
								targetPartList.add(getUnitNode(part, learningProgressRecordUnitList));
							}
						}
						chapterNode.setPartList(targetPartList);
						chapterNode.setSectionNodeList(null);
						//chapterNodeList.add(chapterNode);
					}
					//chapterNode.setChapterObj(chapter);
					chapterNode.setCourseId(chapter.getCourseId());
					chapterNode.setChapterId(chapter.getChapterId());
					chapterNode.setChapterName(chapter.getChapterName());
					chapterNode.setPictureUrl(chapter.getPictureUrl());
					chapterNode.setDepict(chapter.getDepict());
					chapterNode.setSn(chapter.getSn());
					chapterNode.setIsLeafNode(chapter.getIsLeafNode());
					chapterNodeList.add(chapterNode);
				}
				courseDetail.setChapterNodeList(chapterNodeList);
				courseDetail.setPartList(null);
			}//课程下有章，查找并挂载课程的章
			else{
				//课程下没有章，直接挂part列表
				courseDetail.setPartList(partList);
				courseDetail.setChapterNodeList(null);
			}
			//courseDetail.setCourseObj(courseObj);
			courseDetail.setCourseId(courseObj.getCourseId());
			courseDetail.setCategoryId(courseObj.getCategoryId());
			courseDetail.setCourseName(courseObj.getCourseName());
			courseDetail.setTutorId(courseObj.getTutorId());
			courseDetail.setDepict(courseObj.getDepict());
			courseDetail.setSn(courseObj.getSn());
			courseDetail.setPictureUrl(courseObj.getPictureUrl());
			courseDetail.setIsLeafNode(courseObj.getIsLeafNode());
			courseDetail.setParticipantsNum(courseObj.getParticipantsNum());
			courseDetail.setClickRate(courseObj.getClickRate());
			courseDetail.setLearningTargetNumber(courseObj.getLearningTargetNumber());
			//课程的学分设置改为从learning.confcredit获取，在加入课程时进行设置，其它地方都可以改为从learning.confcredit获取
			if(learning!=null){
				courseDetail.setConfCredit(learning.getConfCredit() == null ? 0: learning.getConfCredit().floatValue());
			}
			else{
				courseDetail.setConfCredit(0f);
			}
			
			
			String[] tutorIdStringArray=courseObj.getTutorId().split(",");
			List<Long> tutorIdList=new ArrayList<>();
			for (String tutorIdString : tutorIdStringArray) {
				tutorIdList.add(Long.valueOf(tutorIdString));
			}
			TutorExample tutorExample=new TutorExample();
			TutorExample.Criteria tutorCriteria = tutorExample.createCriteria(); 
			tutorCriteria.andTutorIdIn(tutorIdList);
			List<Tutor> tutorList=(List<Tutor>)tutorService.selectTutors(tutorExample,null).get("data");
			
			CourseCommentExample courseCommentExample=new CourseCommentExample();
			CourseCommentExample.Criteria courseCommentExampleCriteria = courseCommentExample.createCriteria(); 
			courseCommentExampleCriteria.andCourseIdEqualTo(courseId);
			List<CourseComment> courseCommentList =courseCommentService.selectCourseComments(courseCommentExample, 0);
			
			courseDetailPageData.setCourseCommentNum(courseCommentService.countCourseComments(courseCommentExample));
			
			
			courseDetailPageData.setCourseDetail(courseDetail);
			courseDetailPageData.setTutorList(tutorList);
			courseDetailPageData.setCourseCommentList(courseCommentList);
			if(learning!=null && learning.getIsJoin()!=null){
				courseDetailPageData.setIsJoin(learning.getIsJoin());
			}
			if(learning!=null && learning.getIsCollection()!=null){
				courseDetailPageData.setIsCollected(learning.getIsCollection());
			}
			
			//课程点击率加1，可以用队列优化
			courseService.recordClickRate(courseId);

			return courseDetailPageData;
			
		} catch (Exception e) {
			log.error("CourseDetailPage", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	public PartNode getUnitNode(Part part, List<LearningProgressRecordUnit> learningProgressRecordUnitList){
		PartNode partNode=new PartNode();
		partNode.setCourseId(part.getCourseId());
		partNode.setChapterId(part.getChapterId());
		partNode.setSectionId(part.getSectionId());
		partNode.setUnitId(part.getUnitId());
		partNode.setPartId(part.getPartId());
		partNode.setPartName(part.getPartName());
		partNode.setPartType(part.getPartType());
		partNode.setPictureUrl(part.getPictureUrl());
		partNode.setDepict(part.getDepict());
		partNode.setResourceId(part.getResourceId());
		partNode.setObjectiveRightKeyList(part.getObjectiveRightKeyList());
		partNode.setObjectiveTestList(part.getObjectiveTestList());
		partNode.setSubjectiveTestList(part.getSubjectiveTestList());
		partNode.setSn(part.getSn());
		if(learningProgressRecordUnitList==null){
			partNode.setIsSignIn(false);
			partNode.setIsFinish(false);
			return partNode;
		}

		for (LearningProgressRecordUnit learningProgressRecordUnit : learningProgressRecordUnitList) {
			if (learningProgressRecordUnit != null && learningProgressRecordUnit.getPartId() != null && learningProgressRecordUnit.getPartId().longValue()==part.getPartId().longValue()) {
				switch (learningProgressRecordUnit.getPartType()) {
				case 1:
					if(learningProgressRecordUnit.getAttendance() > 0){
						partNode.setIsSignIn(true);
					}
					else{
						partNode.setIsSignIn(false);
					}
					break;
				case 2:
					partNode.setIsFinish(learningProgressRecordUnit.getExercises() > 0);
					break;
				case 3:
					partNode.setIsFinish(learningProgressRecordUnit.getExamine() > 0);
					break;
				default:
					break;
				}
			}
		}
		return partNode;
	}
}
