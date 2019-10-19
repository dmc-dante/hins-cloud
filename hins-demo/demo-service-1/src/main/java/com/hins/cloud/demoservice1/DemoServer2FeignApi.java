package com.hins.cloud.demoservice1;

import com.hins.cloud.common.dto.ApiResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: dqk
 * @Date: 2019/8/20 9:25
 */
@FeignClient("demo-server-2")
interface DemoServer2FeignApi {
	@RequestMapping("testHeaders")
	ApiResult getHeaders();
}
