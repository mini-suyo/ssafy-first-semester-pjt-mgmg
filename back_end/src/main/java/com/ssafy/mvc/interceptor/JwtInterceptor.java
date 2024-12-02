package com.ssafy.mvc.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.mvc.jwt.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {

	private final String HEADER_AUTH = "access_token";

	private JwtUtil jwtUtil;

	@Autowired
	public JwtInterceptor(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}

	// preHandler
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 사전 요청
		if (request.getMethod().equals("OPTIONS")) {
			return true;
		}

		String token = request.getHeader(HEADER_AUTH);
		if (token != null) {
			jwtUtil.validate(token);
			return true;
		}
		throw new Exception("유효하지 않은 접근입니다.");
	}

}
