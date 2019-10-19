package com.hins.cloud.auth.server.controller;

import com.hins.cloud.auth.server.configuratiion.RSAkeyConfiguration;
import com.hins.cloud.auth.server.configuratiion.UserConfiguration;
import com.hins.cloud.common.dto.ApiResult;
import com.hins.cloud.hinsauth.common.dto.AuthConfigInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 授权服务公共接口
 *
 * @Author: dqk
 * @Date: 2019/8/13 16:33
 */
@RestController
@RequestMapping("common")
public class AuthCommonController {
	@Autowired
	RSAkeyConfiguration rsAkeyConfiguration;
	@Autowired
	UserConfiguration userConfiguration;

	/**
	 * 获取公开的授权配置信息
	 *
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "authConfigInfo")
	public ApiResult<AuthConfigInfo> authConfigInfo() {
		AuthConfigInfo authConfigInfo = new AuthConfigInfo().setPub(rsAkeyConfiguration.getKeyPair().getPub())
			.setUserTokenHeader(userConfiguration.getUserTokenHeader());
		return new ApiResult<AuthConfigInfo>(authConfigInfo);
	}
}
