package com.cxc.course.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cxc.course.mapper.UnitMapper;
import com.cxc.course.model.Unit;
import com.cxc.course.model.UnitExample;
import com.cxc.course.param.UnitModifyParam;
import com.cxc.course.param.UnitParam;
import com.cxc.util.DateUtil;
import com.cxc.util.ParamUtil;
import com.cxc.util.PropertyUtil;
import com.cxc.util.ResultUtil;

@Service
public class UnitService {

	@Resource
	private UnitMapper unitMapper;
	
	public Object unit(Long unitId) throws Exception {
		Unit unit = unitMapper.selectByPrimaryKey(unitId);
		if (unit != null) return unit;
		return ResultUtil.NO_DATA_ERROR;
	}
	
	public List<Unit> selectUnitList(UnitExample unitExample) throws Exception {
		return unitMapper.selectByExample(unitExample);
    }
	
	public Object unitDelete(Long unitId) throws Exception {
		if (unitMapper.deleteByPrimaryKey(unitId) == 1) {
			return ResultUtil.EMPTY_RESULT;
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	public Object unit(UnitParam param) throws Exception {
		if (!ParamUtil.checkParamValid(param, null)) {
			return ResultUtil.PARAM_ERROR;
		}
		Unit unit = new Unit();
		PropertyUtil.copy(param, unit);
		
		//UnitType废弃
		if (unit.getUnitType() == null) {
			unit.setUnitType((short) 0);
		}
		if (unit.getDepict() == null) {
			unit.setDepict("");
		}		
		if (unit.getPictureUrl() == null) {
			unit.setPictureUrl("");
		}
		
		if (unit.getPartIdList() == null) {
			unit.setPartIdList("");
		}
		unit.setSn(DateUtil.current());
		
		if (unit.getIsLeafNode() == null) {
			unit.setIsLeafNode(false);
		}
		
		if (unitMapper.insertSelective(unit) == 1) {
			return unitMapper.selectByPrimaryKey(unit.getUnitId());
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	public Object unit(Long unitId, UnitModifyParam param) throws Exception {
		if (!ParamUtil.checkParamValid(param, null) || unitId <= 0) {
			return ResultUtil.PARAM_ERROR;
		}
		Unit unit = new Unit();
		PropertyUtil.copy(param, unit);
		unit.setUnitId(unitId);
		
		if (unitMapper.updateByPrimaryKeySelective(unit) == 1) {
			return unitMapper.selectByPrimaryKey(unitId);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
}
