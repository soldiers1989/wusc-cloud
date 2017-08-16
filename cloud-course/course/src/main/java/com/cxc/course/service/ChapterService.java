package com.cxc.course.service;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cxc.course.mapper.ChapterMapper;
import com.cxc.course.model.Chapter;
import com.cxc.course.model.ChapterExample;
import com.cxc.course.param.ChapterModifyParam;
import com.cxc.course.param.ChapterParam;
import com.cxc.util.DateUtil;
import com.cxc.util.ParamUtil;
import com.cxc.util.PropertyUtil;
import com.cxc.util.ResultUtil;

@Service
public class ChapterService {

	@Resource
	private ChapterMapper chapterMapper;
	
	public Object chapter(Long chapterId) throws Exception {
		Chapter chapter = chapterMapper.selectByPrimaryKey(chapterId);
		if (chapter != null) return chapter;
		return ResultUtil.NO_DATA_ERROR;
	}
	
	public List<Chapter> selectChapterList(ChapterExample  chapterExample) throws Exception {
		return chapterMapper.selectByExample(chapterExample);
    }
	
	public Object chapterDelete(Long chapterId) throws Exception {
		if (chapterMapper.deleteByPrimaryKey(chapterId) == 1) {
			return ResultUtil.EMPTY_RESULT;
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	public Object chapter(ChapterParam param) throws Exception {
		if (!ParamUtil.checkParamValid(param, null)) {
			return ResultUtil.PARAM_ERROR;
		}
		Chapter chapter = new Chapter();
		PropertyUtil.copy(param, chapter);
		
		if (chapter.getDepict() == null) {
			chapter.setDepict("");
		}
		if (chapter.getPictureUrl() == null) {
			chapter.setPictureUrl("");
		}

		if (chapter.getPartIdList() == null) {
			chapter.setPartIdList("");
		}
		
		chapter.setSn(DateUtil.current());
		
		if (chapter.getIsLeafNode() == null) {
			chapter.setIsLeafNode(false);
		}
		
		if (chapterMapper.insertSelective(chapter) == 1) {
			return chapterMapper.selectByPrimaryKey(chapter.getChapterId());
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	public Object chapter(Long chapterId, ChapterModifyParam param) throws Exception {
		if (!ParamUtil.checkParamValid(param, null) || chapterId <= 0) {
			return ResultUtil.PARAM_ERROR;
		}
		Chapter chapter = new Chapter();
		PropertyUtil.copy(param, chapter);
		chapter.setChapterId(chapterId);
		
		if (chapterMapper.updateByPrimaryKeySelective(chapter) == 1) {
			return chapterMapper.selectByPrimaryKey(chapterId);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
}
