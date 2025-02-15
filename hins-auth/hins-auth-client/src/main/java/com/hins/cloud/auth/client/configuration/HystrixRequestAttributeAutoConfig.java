package com.hins.cloud.auth.client.configuration;

import com.hins.cloud.auth.client.hystrix.RequestAttributeHystrixConcurrencyStrategy;
import com.netflix.hystrix.Hystrix;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

/**
 * @Author: dqk
 * @Date: 2019/8/20 17:01
 */
@Configuration
@ConditionalOnClass({Hystrix.class})
@ConditionalOnProperty(value = "feign.hystrix.enabled", matchIfMissing = false)
public class HystrixRequestAttributeAutoConfig {
	@Value("${hystrix.share-request:true}")
	private boolean shareRequest;

	@Bean
	@Nullable
	public RequestAttributeHystrixConcurrencyStrategy hystrixRequestAutoConfiguration() {
		if (!shareRequest) return null;
		return new RequestAttributeHystrixConcurrencyStrategy();
	}

	public boolean isShareRequest() {
		return shareRequest;
	}

	public HystrixRequestAttributeAutoConfig setShareRequest(boolean shareRequest) {
		this.shareRequest = shareRequest;
		return this;
	}
}
