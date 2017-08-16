package com.cxc.system.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cxc.system.mapper.SystemVersionMapper;
import com.cxc.system.model.SystemVersion;
import com.cxc.system.model.SystemVersionExample;
import com.cxc.system.ret.SystemVersionRet;
import com.cxc.util.ResultUtil;

@Service
public class VersionService {

	@Resource
	private SystemVersionMapper systemVersionMapper;
	
	/**
	 * 查询最新版本
	 * @param systemId
	 * @param versionCode
	 * @param terminalType
	 * @return
	 * @throws Exception
	 */
	public Object latestVersion(Long systemId, Long versionCode, String terminalType) throws Exception{
		/**
		 * 1.判断数据有效性 2.查询版本信息 3.组建数据 4.返回
		 */
		//1.判断数据有效性
		if (systemId <=0 || versionCode <= 0 || terminalType.length() > 10) {
			return ResultUtil.PARAM_ERROR;
		}
		//2.查询版本信息
		SystemVersionExample ex = new SystemVersionExample();
		ex.createCriteria().andSystemIdEqualTo(systemId).andPlatformEqualTo(terminalType.toLowerCase()).andStatusEqualTo(SystemVersion.STATUS_VALID);
		ex.setOrderByClause("main_version desc, minor_version desc limit 1");
		List<SystemVersion> data = systemVersionMapper.selectByExample(ex);
		if (data.isEmpty()) {
			return ResultUtil.PARAM_ERROR;
		}
		//3.组建数据
		SystemVersionRet ret = new SystemVersionRet();
		SystemVersion sv = data.get(0);
		ret.setUpdate(sv.getMainVersion() > versionCode);
		if (ret.getUpdate()) {
			ret.setDownloadUrl(sv.getDownloadUrl());
			ret.setForceUpdate(sv.getCompatibleNo() > versionCode);
			ret.setIconUrl(sv.getIconUrl());
			ret.setQrCodeUrl(sv.getQrCodeUrl());
			ret.setVersionDesc(sv.getVersionDesc());
		}
		return ret;
	}
}
