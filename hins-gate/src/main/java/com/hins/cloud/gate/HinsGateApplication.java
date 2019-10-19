package com.hins.cloud.gate;

import com.hins.cloud.common.EnableHinsCommon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication//springboot应用入口
@EnableDiscoveryClient//开启服务发现
@EnableFeignClients//开启feign
@EnableHinsCommon
public class HinsGateApplication {
	public static void main(String[] args) {
		SpringApplication.run(HinsGateApplication.class, args);
	}
}
