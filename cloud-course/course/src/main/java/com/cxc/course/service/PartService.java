package com.cxc.course.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cxc.course.mapper.PartMapper;
import com.cxc.course.model.Part;
import com.cxc.course.model.PartExample;
import com.cxc.course.param.PartModifyParam;
import com.cxc.course.param.PartParam;
import com.cxc.util.DateUtil;
import com.cxc.util.ParamUtil;
import com.cxc.util.PropertyUtil;
import com.cxc.util.ResultUtil;
import com.cxc.course.model.PartExample.Criteria;

@Service
public class PartService {

	@Resource
	private PartMapper partMapper;
	
	public Object part(Long partId) throws Exception {
		Part part = partMapper.selectByPrimaryKey(partId);
		if (part != null) return part;
		return ResultUtil.NO_DATA_ERROR;
	}
	
	public List<Part> selectPartList(PartExample  partExample) throws Exception {
		return partMapper.selectByExample(partExample);
    }
	
	public Object partDelete(Long partId) throws Exception {
		if (partMapper.deleteByPrimaryKey(partId) == 1) {
			return ResultUtil.EMPTY_RESULT;
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	public Object savePart(PartParam param,Long userId) throws Exception {
//		if (!ParamUtil.checkParamValid(param, null)) {
//			return ResultUtil.PARAM_ERROR;
//		}
		PartExample example = new PartExample();
		Criteria criteria = example.createCriteria();
		if(param.getCourseId() != null) {
			criteria.andCourseIdEqualTo(param.getCourseId());
		}
		if(param.getChapterId() != null){
			criteria.andChapterIdEqualTo(param.getChapterId());			
		}
		if(param.getSectionId() != null){
			criteria.andSectionIdEqualTo(param.getSectionId());
		}
		if(param.getUnitId() != null){
			criteria.andUnitIdEqualTo(param.getUnitId());
		}
		partMapper.deleteByExample(example);
		return part(param, userId);
	}
	
	public Object part(PartParam param, Long userId) throws Exception {
		if (!ParamUtil.checkParamValid(param, null)) {
			return ResultUtil.PARAM_ERROR;
		}
		Part part = new Part();
		PropertyUtil.copy(param, part);
		
		if (part.getDepict() == null) {
			part.setDepict("");
		}
		if (part.getPictureUrl() == null) {
			part.setPictureUrl("");
		}
		part.setCreated(DateUtil.current());
		part.setUpdateUserId(userId);

		if (part.getResourceId() == null) {
			part.setResourceId(0l);
		}
		if (part.getObjectiveTestList() == null) {
			part.setObjectiveTestList("");
		}
		if (part.getObjectiveRightKeyList() == null) {
			part.setObjectiveRightKeyList("");
		}
		if (part.getSubjectiveTestList() == null) {
			part.setSubjectiveTestList("");
		}
		part.setSn(DateUtil.current());

		if (partMapper.insertSelective(part) == 1) {
			return partMapper.selectByPrimaryKey(part.getPartId());
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	public Object part(Long partId, PartModifyParam param, Long userId) throws Exception {
		if (!ParamUtil.checkParamValid(param, null) || partId <= 0) {
			return ResultUtil.PARAM_ERROR;
		}
		Part part = new Part();
		PropertyUtil.copy(param, part);
		part.setPartId(partId);
		part.setUpdated(DateUtil.current());
		part.setUpdateUserId(userId);
		
		if (partMapper.updateByPrimaryKeySelective(part) == 1) {
			return partMapper.selectByPrimaryKey(partId);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
}
