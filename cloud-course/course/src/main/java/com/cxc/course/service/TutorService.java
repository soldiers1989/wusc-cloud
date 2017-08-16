package com.cxc.course.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cxc.course.mapper.TutorMapper;
import com.cxc.course.model.Tutor;
import com.cxc.course.model.TutorExample;
import com.cxc.course.param.TutorModifyParam;
import com.cxc.course.param.TutorParam;
import com.cxc.util.ParamUtil;
import com.cxc.util.PropertyUtil;
import com.cxc.util.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class TutorService {

	@Resource
	private TutorMapper tutorMapper;
	
	public Object tutor(Long tutorId) throws Exception {
		Tutor tutor = tutorMapper.selectByPrimaryKey(tutorId);
		if (tutor != null) return tutor;
		return ResultUtil.NO_DATA_ERROR;
	}
	
	public Map<String,Object> selectTutors(TutorExample tutorExample, Integer offset) throws Exception {
		if (offset == null) offset = 0;
		Page<Tutor> page = PageHelper.offsetPage(offset, 20);
        tutorMapper.selectByExample(tutorExample);
        Map<String,Object> mapData = new HashMap<String,Object>();
        mapData.put("total", page.toPageInfo().getTotal());
		mapData.put("data", page.toPageInfo().getList());
		return mapData;
    }
	
	public Object tutorDelete(Long tutorId) throws Exception {
		if (tutorMapper.deleteByPrimaryKey(tutorId) == 1) {
			return ResultUtil.EMPTY_RESULT;
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	public Object tutor(TutorParam param) throws Exception {
		if (!ParamUtil.checkParamValid(param, null)) {
			return ResultUtil.PARAM_ERROR;
		}
		Tutor tutor = new Tutor();
		PropertyUtil.copy(param, tutor);
		
		if (tutor.getPhotoUrl() == null) {
			tutor.setPhotoUrl("");
		}
		if (tutor.getEmail() == null) {
			tutor.setEmail("");
		}
		if (tutor.getResume() == null) {
			tutor.setResume("");
		}
		
		if (tutorMapper.insertSelective(tutor) == 1) {
			return tutorMapper.selectByPrimaryKey(tutor.getTutorId());
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	public Object tutor(Long tutorId, TutorModifyParam param) throws Exception {
		if (!ParamUtil.checkParamValid(param, null) || tutorId <= 0) {
			return ResultUtil.PARAM_ERROR;
		}
		Tutor tutor = new Tutor();
		PropertyUtil.copy(param, tutor);
		tutor.setTutorId(tutorId);
		
		if (tutorMapper.updateByPrimaryKeySelective(tutor) == 1) {
			return tutorMapper.selectByPrimaryKey(tutorId);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
}
