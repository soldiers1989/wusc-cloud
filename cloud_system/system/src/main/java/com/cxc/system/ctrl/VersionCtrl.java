package com.cxc.system.ctrl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxc.cache.Cache;
import com.cxc.system.ret.SystemVersionRet;
import com.cxc.system.service.VersionService;
import com.cxc.util.ResultUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(headers="Accept=application/json; version=1.0")
public class VersionCtrl {
	
	private static final Logger log = LoggerFactory.getLogger(VersionCtrl.class);
	
	@Resource
	private VersionService versionService;
	
	@ApiOperation(value="根据客户端版本查询是否存在最新版本以及是否需要升级", notes="system_id:书院app-1 version_code:版本号，整形 terminal_type:android/ios",
			response = SystemVersionRet.class, tags="version-get")
	@RequestMapping(value="system/{system_id}/version/{version_code}", method=RequestMethod.GET)
	@Cache(type=SystemVersionRet.class)
	public Object systemVersion(@PathVariable("system_id") Long systemId, @PathVariable("version_code")Long versionCode, 
			@RequestParam("terminal_type") String terminalType) {
		try {
			return versionService.latestVersion(systemId, versionCode, terminalType);
		} catch (Exception e) {
			log.error("VersionCtrl error", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
}
