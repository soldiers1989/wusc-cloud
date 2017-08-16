package com.cxc.ms.service.mvc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cxc.ms.service.mvc.dao.OrganizationMapper;
import com.cxc.ms.service.mvc.model.Organization;
import com.cxc.ms.service.mvc.ret.Organizations;
import com.cxc.ms.service.mvc.vo.OrganizationParam;
import com.cxc.util.DateUtil;
import com.cxc.util.ParamUtil;
import com.cxc.util.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class OrganizationService {

	@Resource
	private OrganizationMapper organizationMapper;
	
	public Object organizations() {
		//1.从mysql中读出所有组织,将组织按照类别分类 2.返回结果
		
		//1.从mysql中读出所有组织,将组织按照类别分类
		List<Organization> list = organizationMapper.selectByExample(null);
		if (list.isEmpty()) {
			return null;
		}
		final Organizations ret = new Organizations();
		list.stream().forEach(new Consumer<Organization>() {
			@Override
			public void accept(Organization t) {
				List<Organization> os = null;
				if (t.getCategory() == Organization.CATEGORY_SCHOOL) {
					os = ret.getSchool();
				} else if (t.getCategory() == Organization.CATEGORY_COMPANY) {
					os = ret.getCompany();
				} else if (t.getCategory() == Organization.CATEGORY_MECHANISM) {
					os = ret.getMechanism();
				} else if (t.getCategory() == Organization.CATEGORY_ORGANIZATION) {
					os = ret.getOrganization();
				}
				if (os != null) os.add(t);
				t.setCategory(null);//避免暴露太多信息
				t.setCreateTime(null);//避免暴露太多信息
				t.setUpdateTime(null);//避免暴露太多信息
			}
		});
		//2.返回结果
		return ret;
	}
	
	
	/**
	 * 根据名称获取所有的学校/组织，不支持分页
	 * @param name
	 * @return
	 * @throws Exception
	 * @author linmei.yan
	 */
	public List<Organization> getTotalByOrgName (String name) throws Exception{
		return organizationMapper.selectByOrgName(name);
	}
	
	/**
	 * 根据名称获取所有的学校/组织，支持分页
	 * @param name
	 * @return
	 * @author linmei.yan
	 */
	public Map<String,Object> getByOrgName (String name,Integer offset) throws Exception{
		if(offset == null){
			offset = 0;
		}
		Map<String,Object> mapData = new HashMap<String,Object>();
		Page<Organization> page = PageHelper.offsetPage(offset, 20);
		if(name != null){
			name = "%" + name + "%";
		}
		organizationMapper.selectByOrgName(name);
		mapData.put("total", page.toPageInfo().getTotal());
		mapData.put("organizations", page.toPageInfo().getList());
		return mapData;
	}
	
	/**
	 * 新增学校
	 * @param name
	 * @return
	 * @throws Exception
	 * @author linmei.yan
	 */
	public Object insertOrganization(OrganizationParam param) throws Exception {
		if(!ParamUtil.checkParamValid(param, null)){
			return ResultUtil.SYSTEM_ERROR;
		}
		Organization org = new Organization();
		org.setName(param.getName());
		org.setCategory((short)1);
		org.setCreateTime(DateUtil.current());
		org.setUpdateTime(org.getCreateTime());
		org.setPictureUrl(param.getPictureUrl());
		if(organizationMapper.insertSelective(org) == 1){
			return ResultUtil.EMPTY_RESULT;
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	/**
	 * @param organizationId
	 * @return
	 * @throws Exception
	 * @author linmei.yan
	 */
	public Object getOrganizationById(Long organizationId) throws Exception {
		return organizationMapper.selectByPrimaryKey(organizationId);
	}
	
	/**
	 * @param id
	 * @return
	 * @throws Exception
	 * @author linmei.yan
	 */
	public Object deleteOrganizationById(Long id) throws Exception {
		if(organizationMapper.deleteByPrimaryKey(id) == 1){
			return ResultUtil.EMPTY_RESULT;
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	
	/**
	 * 编辑学校
	 * @param id
	 * @param param
	 * @return
	 * @throws Exception
	 * @author linmei.yan
	 */
	public Object updateOrganizationById(Long id, OrganizationParam param) throws Exception {
		if(!ParamUtil.checkParamValid(param, null) || id < 1){
			return ResultUtil.SYSTEM_ERROR;
		}
		Organization org = new Organization();
		org.setId(id);
		org.setName(param.getName());
		org.setUpdateTime(DateUtil.current());
		org.setPictureUrl(param.getPictureUrl());
		if(organizationMapper.updateByPrimaryKeySelective(org) == 1){
			return ResultUtil.EMPTY_RESULT;
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
}
