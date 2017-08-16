package com.cxc.auth;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthInterceptor implements HandlerInterceptor {
	
	private static final String COLLEGE_ROLE = "College_Role";
	private ObjectMapper objectMapper;
	
	public AuthInterceptor(ObjectMapper objectMapper) {
		super();
		this.objectMapper = objectMapper;
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod hm = (HandlerMethod) handler;
			AuthRequired auth = hm.getMethodAnnotation(AuthRequired.class);
			if (auth != null && auth.role() != null) {
				String roles = request.getHeader(COLLEGE_ROLE);
				Set<?> roleSet = objectMapper.readValue(roles, Set.class);
				RoleType[] rts = auth.role();
				for (RoleType rt : rts) {
					if (roleSet.contains(rt.toString())) return true;
				}
				response.setStatus(403);
				response.flushBuffer();
				response.getWriter().close();
				return false;
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}
}
