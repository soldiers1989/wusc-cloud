package com.cxc.system.ctrl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxc.cache.Cache;
import com.cxc.system.model.Company;
import com.cxc.system.service.CompanyService;
import com.cxc.util.ResultUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(headers="Accept=application/json; version=1.0")
public class CompanyCtrl {
	private static final Logger log = LoggerFactory.getLogger(CompanyCtrl.class);
	
	@Resource
	private CompanyService companyService;
	
	@ApiOperation(value="根据编号查询公司", response = Company.class, tags="companies-id-get", notes="company_id:整形")
	@RequestMapping(value="companies/{company_id}", method=RequestMethod.GET)
	@Cache(type=Company.class)
	public Object companies(@PathVariable("company_id") Long companyId) {
		try {
			return companyService.company(companyId);
		} catch (Exception e) {
			log.error("CompanyCtrl error", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
}
