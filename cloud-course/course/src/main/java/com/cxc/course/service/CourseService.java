package com.cxc.course.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cxc.course.model.CourseExample;
import com.cxc.course.model.Part;
import com.cxc.course.model.PartExample;
import com.cxc.course.model.Section;
import com.cxc.course.model.SectionExample;
import com.cxc.course.model.Unit;
import com.cxc.course.model.UnitExample;
import com.cxc.course.mapper.ChapterMapper;
import com.cxc.course.mapper.CourseMapper;
import com.cxc.course.mapper.PartMapper;
import com.cxc.course.mapper.SectionMapper;
import com.cxc.course.mapper.UnitMapper;
import com.cxc.course.model.Chapter;
import com.cxc.course.model.ChapterExample;
import com.cxc.course.model.Course;
import com.cxc.course.param.CourseModifyParam;
import com.cxc.course.param.CourseParam;
import com.cxc.course.ret.ChapterContentRet;
import com.cxc.course.ret.CourseContentRet;
import com.cxc.course.ret.SectionContentRet;
import com.cxc.course.ret.UnitContentRet;
import com.cxc.util.DateUtil;
import com.cxc.util.ParamUtil;
import com.cxc.util.PropertyUtil;
import com.cxc.util.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class CourseService {
	
	private static final Logger log = LoggerFactory.getLogger(CourseService.class);

	@Resource
	private CourseMapper courseMapper;
	@Resource
	private ChapterMapper chapterMapper;
	@Resource
	private SectionMapper sectionMapper;
	@Resource
	private UnitMapper unitMapper;
	@Resource
	private PartMapper partMapper;
	
	public Object course(Long courseId) throws Exception {
		Course course = courseMapper.selectByPrimaryKey(courseId);
		if (course != null) return course;
		return ResultUtil.NO_DATA_ERROR;
	}
	
	public List<Course> selectCourses(CourseExample courseExample, Integer offset) throws Exception {
		if (offset == null) offset = 0;
		Page<Course> page = PageHelper.offsetPage(offset, 20);
        courseMapper.selectByExample(courseExample);
        return page.toPageInfo().getList();
    }
	
	public Map<String, Object> getCourses(CourseExample courseExample, Integer offset) throws Exception {
		if (offset == null) offset = 0;
		Page<Course> page = PageHelper.offsetPage(offset, 20);
        courseMapper.selectByExample(courseExample);
        Map<String, Object> mapData = new HashMap<>();
        mapData.put("total", page.toPageInfo().getTotal());
		mapData.put("data", page.toPageInfo().getList());
		return mapData;
    }
	
	public List<Course> selectCourses(CourseExample courseExample) throws Exception {
        return courseMapper.selectByExample(courseExample);
    }
	
	public Object courseDelete(Long courseId) throws Exception {
		if (courseMapper.deleteByPrimaryKey(courseId) == 1) {
			return ResultUtil.EMPTY_RESULT;
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	public Object course(CourseParam param, Long userId) throws Exception {
		if (!ParamUtil.checkParamValid(param, null)) {
			return ResultUtil.PARAM_ERROR;
		}
		Course course = new Course();
		PropertyUtil.copy(param, course);
		course.setCreated(DateUtil.current());
		course.setUpdateUserId(userId);
		if (course.getPictureUrl() == null) {
			course.setPictureUrl("");
		}
		if (course.getIconUrl() == null) {
			course.setIconUrl("");
		}
		if (course.getRecommendedLevel() == null) {
			course.setRecommendedLevel((short) 0);
		}
		
		if (course.getPartIdList() == null) {
			course.setPartIdList("");
		}
		
		if (course.getTutorId() == null) {
			course.setTutorId("");
		}
		
		course.setSn(DateUtil.current());
		
		if (course.getClickRate() == null) {
			course.setClickRate(0L);
		}
		if (course.getParticipantsNum() == null) {
			course.setParticipantsNum(0L);
		}
		if (course.getAttendanceGrade() == null) {
			course.setAttendanceGrade((short) 0);
		}
		if (course.getExercisesGrade() == null) {
			course.setExercisesGrade((short)0);
		}
		if (course.getExamineGrade() == null) {
			course.setExamineGrade((short)0);
		}
		if (course.getPassingGrade() == null) {
			course.setPassingGrade((short)0);
		}
		if (course.getIsLeafNode() == null) {
			course.setIsLeafNode(false);
		}
		if (course.getPartIdList() == null) {
			course.setPartIdList("");
		}
		if (courseMapper.insertSelective(course) == 1) {
			return courseMapper.selectByPrimaryKey(course.getCourseId());
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	public Object course(Long courseId, CourseModifyParam param, Long userId) throws Exception {
		if (!ParamUtil.checkParamValid(param, null) || courseId <= 0) {
			return ResultUtil.PARAM_ERROR;
		}
		Course course = new Course();
		PropertyUtil.copy(param, course);
		course.setCourseId(courseId);
		course.setUpdated(DateUtil.current());
		course.setUpdateUserId(userId);
		if (courseMapper.updateByPrimaryKeySelective(course) == 1) {
			return courseMapper.selectByPrimaryKey(courseId);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	public Object recordClickRate(Long courseId) throws Exception {
		if (courseMapper.updateClickRateByPrimaryKey(courseId)== 1) {
			return Boolean.TRUE;
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	public Object recordParticipantsNum(Long courseId) throws Exception {
		if (courseMapper.updateParticipantsNumByPrimaryKey(courseId) == 1) {
			return Boolean.TRUE;
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	/**
	 * 获取课程的内容目录
	 * @param courseId
	 * @return
	 * @throws Exception
	 */
	public CourseContentRet courseContent(Long courseId) throws Exception {
		/**
		 * 1.读取所有的chapter 2.读取所有的section 3.读取所有的unit 4.读取所有的part 5.组建树并返回
		 */
		//1.读取所有的chapter
		ChapterExample ce = new ChapterExample();
		ce.createCriteria().andCourseIdEqualTo(courseId);
		List<Chapter> chapters = chapterMapper.selectByExample(ce);
		//2.读取所有的section
		SectionExample se = new SectionExample();
		se.createCriteria().andCourseIdEqualTo(courseId);
		List<Section> sections = sectionMapper.selectByExample(se);
		//3.读取所有的unit
		UnitExample ue = new UnitExample();
		ue.createCriteria().andCourseIdEqualTo(courseId);
		List<Unit> units = unitMapper.selectByExample(ue);
		//4.读取所有的part
		PartExample pe = new PartExample();
		pe.createCriteria().andCourseIdEqualTo(courseId);
		List<Part> parts = partMapper.selectByExample(pe);
		//5.组建树
		CourseContentRet course = new CourseContentRet();
		Map<Long, ChapterContentRet> chapterIdToChapterMap = new HashMap<>();
		if (!chapters.isEmpty()) {
			List<Object> chapterChildren = chapters.stream().map(t -> {
				ChapterContentRet ret = new ChapterContentRet();
				PropertyUtil.copy(t, ret); 
				chapterIdToChapterMap.put(t.getChapterId(), ret);
				return (Object) ret;
				}).collect(Collectors.toList());
			course.setChildren(chapterChildren);//关联course与chapter
		} else {
			course.setChildren(parts.stream().map(t -> (Object)t).collect(Collectors.toList()));
		}
		Map<Long, SectionContentRet> sectionIdToSectionMap = new HashMap<>();
		if (!sections.isEmpty()) {
			Map<Long, List<Object>> chapterIdToSectionsMap = new HashMap<>();
			sections.stream().forEach(t -> {
				List<Object> list = chapterIdToSectionsMap.getOrDefault(t.getChapterId(), new ArrayList<Object>());
				SectionContentRet r = new SectionContentRet();
				PropertyUtil.copy(t, r);
				list.add(r);
				sectionIdToSectionMap.put(r.getSectionId(), r);
				chapterIdToSectionsMap.put(t.getChapterId(), list);
			});
			chapterIdToChapterMap.keySet().stream().forEach(t -> {
				ChapterContentRet chapter = chapterIdToChapterMap.get(t);
				chapter.setChildren(chapterIdToSectionsMap.get(t));
			});//管理chapter与section
		}
		Map<Long, UnitContentRet> unitIdToUnitMap = new HashMap<>();
		if (!units.isEmpty()) {
			Map<Long, List<Object>> sectionIdToUnitsMap = new HashMap<>();
			units.stream().forEach(t -> {
				List<Object> list = sectionIdToUnitsMap.getOrDefault(t.getSectionId(), new ArrayList<Object>());
				UnitContentRet r = new UnitContentRet();
				PropertyUtil.copy(t, r);
				list.add(r);
				unitIdToUnitMap.put(t.getUnitId(), r);
				sectionIdToUnitsMap.put(t.getSectionId(), list);
			});
			sectionIdToSectionMap.keySet().stream().forEach(t -> {
				SectionContentRet section = sectionIdToSectionMap.get(t);
				if (section != null) {
					section.setChildren(sectionIdToUnitsMap.get(t));
				}
			});//关联unit与section
		}
		if (!chapters.isEmpty()) {
			parts.stream().forEach(t -> {
				if (t.getUnitId() != null) {
					UnitContentRet unit = unitIdToUnitMap.get(t.getUnitId());
					if (unit != null) {
						List<Object> list = (List<Object>) unit.getChildren();
						if (list == null) {
							list = new LinkedList<Object>();
							unit.setChildren(list);
						}
						list.add(t);
					}
				} else if (t.getSectionId() != null) {
					SectionContentRet section = sectionIdToSectionMap.get(t.getSectionId());
					if (section != null) {
						List<Object> list = (List<Object>) section.getChildren();
						if (list == null) {
							list = new LinkedList<Object>();
							section.setChildren(list);
						}
						list.add(t);
					}
				} else if (t.getChapterId() != null) {
					ChapterContentRet chapter = chapterIdToChapterMap.get(t.getChapterId());
					if (chapter != null) {
						List<Object> list = (List<Object>) chapter.getChildren();
						if (list == null) {
							list = new LinkedList<Object>();
							chapter.setChildren(list);
						}
						list.add(t);
					}
				}
			});
		}
		return course;
	}
}
