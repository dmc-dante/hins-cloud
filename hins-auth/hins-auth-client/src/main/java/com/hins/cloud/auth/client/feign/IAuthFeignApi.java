package com.hins.cloud.auth.client.feign;

import com.hins.cloud.common.dto.ApiResult;
import com.hins.cloud.hinsauth.common.dto.AuthConfigInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: dqk
 * @Date: 2019/8/15 14:23
 */
@FeignClient(value = "auth-server")
public interface IAuthFeignApi {
	@RequestMapping(value = "common/authConfigInfo", method = RequestMethod.POST)
	ApiResult<AuthConfigInfo> getAuthConfigInfo();
}
