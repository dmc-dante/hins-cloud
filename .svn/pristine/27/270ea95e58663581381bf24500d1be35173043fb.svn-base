package com.hins.cloud.auth.server.controller;

import com.hins.cloud.auth.server.configuratiion.UserConfiguration;
import com.hins.cloud.auth.server.service.AuthService;
import com.hins.cloud.common.constant.ApiResultConst;
import com.hins.cloud.common.dto.ApiResult;
import com.hins.cloud.hinsauth.common.dto.AuthParam;
import com.hins.cloud.hinsauth.common.dto.TokenResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户token接口
 *
 * @Author: dqk
 * @Date: 2019/8/13 16:33
 */
@RestController
@RequestMapping("user")
public class AuthController {
	@Autowired
	UserConfiguration userConfiguration;
	@Autowired
	private AuthService authService;
	@Autowired
	private HttpServletRequest request;

	@RequestMapping(value = "token")
	public ApiResult<TokenResult> token(@RequestBody AuthParam param) {
		String header = request.getHeader("aa");
		TokenResult auth = authService.auth(param);
		if (auth != null) {
			return new ApiResult<TokenResult>(ApiResultConst.SUCCESS_BASE, auth);
		} else {
			return new ApiResult<TokenResult>(ApiResultConst.ERROR_BASE);
		}
	}
}
