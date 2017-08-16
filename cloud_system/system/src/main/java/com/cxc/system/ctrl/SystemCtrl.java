package com.cxc.system.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxc.system.ret.CurrentRet;
import com.cxc.util.DateUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(headers="Accept=application/json; version=1.0")
public class SystemCtrl {
	private static final Logger log = LoggerFactory.getLogger(SystemCtrl.class);
	
	@RequestMapping(path="/system_time", method=RequestMethod.GET)
	@ApiOperation(value="查询服务器时间",  response = CurrentRet.class)
	public Object current() {
		CurrentRet ret = new CurrentRet();
		ret.setTime(DateUtil.current());
		return ret;
	}
}
