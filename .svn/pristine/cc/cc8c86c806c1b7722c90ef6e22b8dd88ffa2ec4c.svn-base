package com.hins.cloud.auth.client.interceptor;

import com.hins.cloud.auth.client.annotation.IgnoreUserTokenValidate;
import com.hins.cloud.auth.client.configuration.UserAuthConfig;
import com.hins.cloud.common.exception.TokenValidateException;
import com.hins.cloud.common.support.CurrentRequestHolder;
import com.hins.cloud.common.util.StringUtils;
import com.hins.cloud.hinsauth.common.jwt.IJWTInfo;
import com.hins.cloud.hinsauth.common.jwt.JWTHelper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户请求拦截器
 */
public class UserAuthRestInterceptor extends HandlerInterceptorAdapter {
	private Logger logger = LoggerFactory.getLogger(UserAuthRestInterceptor.class);
	@Autowired
	private UserAuthConfig userAuthConfig;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HandlerMethod handlerMethod = (HandlerMethod) handler;
//		 配置该注解，说明不进行用户拦截
		IgnoreUserTokenValidate annotation = handlerMethod.getBeanType().getAnnotation(IgnoreUserTokenValidate.class);
		if (annotation == null) {
			annotation = handlerMethod.getMethodAnnotation(IgnoreUserTokenValidate.class);
		}
		if (annotation != null) {
			return super.preHandle(request, response, handler);
		}
		String token = request.getHeader(userAuthConfig.getTokenHeader());
		if (StringUtils.isEmpty(token)) {
			if (request.getCookies() != null) {
				for (Cookie cookie : request.getCookies()) {
					if (cookie.getName().equals(userAuthConfig.getTokenHeader())) {
						token = cookie.getValue();
					}
				}
			}
		}
		IJWTInfo infoFromToken = getInfoFromToken(token);
		CurrentRequestHolder.setUserId(infoFromToken.getId());
		CurrentRequestHolder.setRequest(request);
		return super.preHandle(request, response, handler);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		CurrentRequestHolder.remove();
		super.afterCompletion(request, response, handler, ex);
	}

	/**
	 * 从token中解析数据
	 *
	 * @param token
	 * @return
	 * @throws Exception
	 */
	private IJWTInfo getInfoFromToken(String token) throws Exception {
		try {
			return JWTHelper.getInfoFromToken(token, userAuthConfig.getPubKeyByte());
		} catch (ExpiredJwtException ex) {
			throw new TokenValidateException("User token expired!");
		} catch (SignatureException ex) {
			throw new TokenValidateException("User token signature error!");
		} catch (IllegalArgumentException ex) {
			throw new TokenValidateException("User token is null or empty!");
		}
	}
}
