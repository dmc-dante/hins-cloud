package com.hins.cloud.demoservice2;

import com.hins.cloud.common.dto.ApiResult;
import com.hins.cloud.common.log.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @Author: dqk
 * @Date: ${Date} ${time}
 */
@RestController
public class TestController {
	@Autowired
	LoadBalancerClient loadBalancerClient;
	private HttpServletRequest request;

	@GetMapping("/test")
	public String test() {
		// 通过spring cloud common中的负载均衡接口选取服务提供节点实现接口调用
		ServiceInstance serviceInstance = loadBalancerClient.choose("dome-service-1");
		String url = serviceInstance.getUri() + "/hello?name=" + "didi";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(url, String.class);
		return "Invoke  : " + url + ",return :" + result;
	}

	/**
	 * 测试headers
	 *
	 * @param request
	 * @return
	 */
	@GetMapping("/testHeaders")
	public ApiResult testHeaders(HttpServletRequest request) {
		this.request = request;
		Enumeration<String> headerNames = request.getHeaderNames();
		Logger logger = LoggerFactory.getLogger(this.getClass());
		String result = "";
		while (headerNames.hasMoreElements()) {
			String s = headerNames.nextElement();
			logger.info(s + ":" + request.getHeader(s));
			result += s + ":" + request.getHeader(s) + "，";
		}
		return new ApiResult(result);
	}
}
