package com.cxc.system.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cxc.system.mapper.CompanyMapper;
import com.cxc.system.model.Company;
import com.cxc.util.ResultUtil;

@Service
public class CompanyService {

	@Resource
	private CompanyMapper companyMapper;
	
	/**
	 * 根据id查询公司
	 * @param companyId
	 * @return
	 * @throws Exception
	 */
	public Object company(Long companyId)  throws Exception {
		if (companyId <= 0) return ResultUtil.PARAM_ERROR;
		Company company = companyMapper.selectByPrimaryKey(companyId);
		if (company == null) return ResultUtil.NO_DATA_ERROR;
		return company;
	}
}
