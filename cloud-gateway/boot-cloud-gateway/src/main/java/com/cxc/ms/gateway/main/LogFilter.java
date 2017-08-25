package com.cxc.ms.gateway.main;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class LogFilter extends ZuulFilter {

	private static final Logger log = LoggerFactory.getLogger(LogFilter.class);
	
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		
	    HttpServletRequest request = ctx.getRequest();
		try {
			log.warn("method:{},url:{},params:{},user:{},ip:{},body:{},response:{}", request.getMethod(),request.getRequestURL(), 
					request.getQueryString(), request.getHeader("user_id"), request.getRemoteAddr(), readBody(request), readResponseBody(ctx));
		} catch (Exception e) {
			log.error("log filter error:", e);
		}
		return null;
	}
	
	private String readBody(HttpServletRequest request) throws IOException {
		if (StringUtils.isNotBlank(request.getContentType()) ) {
			if (StringUtils.isNotBlank(request.getContentType()) && request.getContentType().contains("json")) {
				return StreamUtils.copyToString(request.getInputStream(), Charset.forName("utf8")).replaceAll("[\r\n ]", "");
			} else {
				return String.format("not supported:", request.getContentType());
			}
		}
		return "";
	}
	
	private String readResponseBody(RequestContext ctx) {
		HttpServletRequest request = ctx.getRequest();
		String accept = request.getHeader("Accept");
		if (ctx.getResponseBody() == null &&  accept != null && accept.contains("json")) {
			try (final InputStream responseDataStream = ctx.getResponseDataStream()) {
				if (responseDataStream == null) return "";
				final String responseData = StreamUtils.copyToString(responseDataStream, Charset.forName("utf8"));
				ctx.setResponseBody(responseData);
				return responseData == null ? "": responseData.substring(0, Math.min(200, responseData.length()));
			} catch (IOException e) {
				log.warn("Error reading body", e);
			}
		}
		return ctx.getResponseBody();
	}
	
	@Override
	public String filterType() {
		return "route";
	}

	@Override
	public int filterOrder() {
		return Integer.MAX_VALUE;
	}

}
