package com.hins.cloud.demoservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DemoService2Application {
	public static void main(String[] args) {
		SpringApplication.run(DemoService2Application.class, args);
	}
}
