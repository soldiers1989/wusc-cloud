package com.cxc.video.service;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.stereotype.Service;

import com.cxc.util.ErrorModel;
import com.cxc.util.ParamUtil;
import com.cxc.util.ResultUtil;
import com.cxc.video.mapper.ResourceMapper;
import com.cxc.video.model.Resource;
import com.cxc.video.model.User;
import com.cxc.video.param.ResourceParam;

/**
 * 资源管理服务，比如视频、文档等
 * @author wanglei
 * 2017-4-28
 */
@Service
public class ResourceService {
	@javax.annotation.Resource
	private ResourceMapper resourceMapper;
	
	@javax.annotation.Resource
	private UserRemoteService userRemoteService;
	
	private ErrorModel NO_PASS_ERROR = new ErrorModel("401", "您的信息尚未审核，无法进一步操作");
	
	public Object resource(Long resourceId, Long userId) throws Exception{
		//1.判断是不是审核通过的用户 2.查询结果并返回
		//1.判断是不是审核通过的用户 
		User user = userRemoteService.userIfo(userId);
		if (user != null) {
			if (user.getStatus() == User.USERSTATUS_PASSED) {
				
				//2.查询结果并返回
				Resource resource = resourceMapper.selectByPrimaryKey(resourceId);
				if (resource == null) {
					return ResultUtil.NO_DATA_ERROR;
				}
				return resource;
			}
			return NO_PASS_ERROR;
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	/**
	 * @param resource
	 * @return
	 * @author linmei.yan
	 */
	public Object insertResource(ResourceParam param) throws Exception {
		if (!ParamUtil.checkParamValid(param, null)) {
			return ResultUtil.PARAM_ERROR;
		}
		Resource resource = new Resource();
		PropertyUtils.copyProperties(resource, param);
		if(resourceMapper.insertSelective(resource) == 1){
			return resourceMapper.selectByPrimaryKey(resource.getResourceId());
		}
		return ResultUtil.SYSTEM_ERROR;
	}
}
