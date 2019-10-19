package com.hins.cloud.demoservice1;

import com.hins.cloud.auth.client.feign.IAuthFeignApi;
import com.hins.cloud.common.dto.ApiResult;
import com.hins.cloud.demoservice1.entity.TestUser;
import com.hins.cloud.demoservice1.mapper.TestUserMapper;
import com.hins.cloud.hinsauth.common.dto.AuthConfigInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: dqk
 * @Date: ${Date} ${time}
 */
@RestController
public class TestController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	IAuthFeignApi authFeignApi;
	@Autowired
	DemoServer2FeignApi demoServer2FeignApi;
	/**
	 *
	 */
	@Value("${server.port}")
	private String port;
	@Autowired
	private TestUserMapper userMapper;

	@GetMapping("/hello")
	public String hello(@RequestParam String name) {
		log.info("invoked name = " + name + "\n");
		return "port= " + port + "，hello " + name;
	}

	@GetMapping("/saveUser")
	public TestUser saveUser(@RequestParam String name) {
		TestUser testUser = new TestUser().setName(name);
		userMapper.insert(testUser);
		return testUser;
	}

	@RequestMapping("authConfigInfo")
	public ApiResult authConfigInfo() {
		ApiResult<AuthConfigInfo> authConfigInfo = authFeignApi.getAuthConfigInfo();
		return authConfigInfo;
	}

	@RequestMapping("getHeaders")
	public ApiResult getHeaders() {
		return demoServer2FeignApi.getHeaders();
	}
}
