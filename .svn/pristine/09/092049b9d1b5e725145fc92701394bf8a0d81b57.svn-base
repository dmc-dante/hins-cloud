package com.hins.cloud.auth.server.feign;

import com.hins.cloud.common.dto.ApiResult;
import com.hins.cloud.hinsauth.common.dto.AuthParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * 调用用户服务
 */
//@FeignClient(value = "ace-admin", configuration = FeignConfiguration.class)
public interface IUserFeignApi {
	@RequestMapping(value = "/api/user/validate", method = RequestMethod.POST)
	public ApiResult<Map<String, Object>> validate(@RequestBody AuthParam param);
}
