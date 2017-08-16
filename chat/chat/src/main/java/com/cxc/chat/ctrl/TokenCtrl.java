package com.cxc.chat.ctrl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxc.cache.Cache;
import com.cxc.chat.easemob.TokenService;
import com.cxc.chat.easemob.model.TokenResult;
import com.cxc.util.ResultUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
public class TokenCtrl {
	
	private static final Logger log = LoggerFactory.getLogger(TokenCtrl.class);

	@Resource
	private TokenService tokenService;
	
	@ApiOperation(value="获取token", response=TokenResult.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(path="token", method=RequestMethod.GET)
	@Cache(type=TokenResult.class, time=24*3600*1000, key="college.cache.chat.easemob.token")
	public Object token() {
		try {
			return tokenService.token();
		} catch (Exception e) {
			log.error("TokenCtrl error", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
}
