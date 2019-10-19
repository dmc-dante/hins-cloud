package com.hins.cloud.auth.server.interceptor;

import com.hins.cloud.auth.server.configuratiion.UserConfiguration;
import com.hins.cloud.auth.server.util.JwtTokenUtil;
import com.hins.cloud.common.support.CurrentRequestHolder;
import com.hins.cloud.hinsauth.common.jwt.IJWTInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户请求token授权前置拦截处理器
 *
 * @Author: dqk
 * @Date: 2019/8/13 15:37
 */
public class UserAuthRestInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private UserConfiguration userConfiguration;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String token = request.getHeader(userConfiguration.getUserTokenHeader());
		IJWTInfo infoFromToken = jwtTokenUtil.getInfoFromToken(token);
		CurrentRequestHolder.setUserId(infoFromToken.getId());
		return super.preHandle(request, response, handler);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		CurrentRequestHolder.remove();
		super.afterCompletion(request, response, handler, ex);
	}
}
