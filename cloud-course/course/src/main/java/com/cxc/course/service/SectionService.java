package com.cxc.course.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cxc.course.mapper.SectionMapper;
import com.cxc.course.model.Section;
import com.cxc.course.model.SectionExample;
import com.cxc.course.param.SectionModifyParam;
import com.cxc.course.param.SectionParam;
import com.cxc.util.DateUtil;
import com.cxc.util.ParamUtil;
import com.cxc.util.PropertyUtil;
import com.cxc.util.ResultUtil;

@Service
public class SectionService {

	@Resource
	private SectionMapper sectionMapper;
	
	public Object section(Long sectionId) throws Exception {
		Section section = sectionMapper.selectByPrimaryKey(sectionId);
		if (section != null) return section;
		return ResultUtil.NO_DATA_ERROR;
	}
	
	public List<Section> selectSectionList(SectionExample sectionExample) throws Exception {
		return sectionMapper.selectByExample(sectionExample);
    }
	
	public Object sectionDelete(Long sectionId) throws Exception {
		if (sectionMapper.deleteByPrimaryKey(sectionId) == 1) {
			return ResultUtil.EMPTY_RESULT;
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	public Object section(SectionParam param) throws Exception {
		if (!ParamUtil.checkParamValid(param, null)) {
			return ResultUtil.PARAM_ERROR;
		}
		Section section = new Section();
		PropertyUtil.copy(param, section);

		if (section.getDepict() == null) {
			section.setDepict("");
		}
		if (section.getPictureUrl() == null) {
			section.setPictureUrl("");
		}
		section.setSn(DateUtil.current());
		
		if (section.getPartIdList() == null) {
			section.setPartIdList("");
		}
		if (section.getIsLeafNode() == null) {
			section.setIsLeafNode(false);
		}
		section.setSn(DateUtil.current());
		
		if (sectionMapper.insertSelective(section) == 1) {
			return sectionMapper.selectByPrimaryKey(section.getSectionId());
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	public Object section(Long sectionId, SectionModifyParam param) throws Exception {
		if (!ParamUtil.checkParamValid(param, null) || sectionId <= 0) {
			return ResultUtil.PARAM_ERROR;
		}
		Section section = new Section();
		PropertyUtil.copy(param, section);
		section.setSectionId(sectionId);
		
		if (sectionMapper.updateByPrimaryKeySelective(section) == 1) {
			return sectionMapper.selectByPrimaryKey(sectionId);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
}
