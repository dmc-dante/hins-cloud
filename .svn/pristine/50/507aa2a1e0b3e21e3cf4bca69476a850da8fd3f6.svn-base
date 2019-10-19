package com.hins.cloud.demoservice1;

import com.hins.cloud.auth.client.EnableAuthClient;
import com.hins.cloud.tkmybatis.EnableTkMybatis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAuthClient
@EnableTkMybatis
@EnableFeignClients({"com.hins.cloud"})
//@EnableScheduling
public class DemoService1Application {
	public static void main(String[] args) {
		SpringApplication.run(DemoService1Application.class, args);
	}
}
