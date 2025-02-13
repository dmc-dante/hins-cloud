package com.hins.cloud.auth.client.runner;

import com.hins.cloud.auth.client.configuration.UserAuthConfig;
import com.hins.cloud.auth.client.feign.IAuthFeignApi;
import com.hins.cloud.common.dto.ApiResult;
import com.hins.cloud.common.log.LoggerFactory;
import com.hins.cloud.hinsauth.common.dto.AuthConfigInfo;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 监听完成时触发
 */
@Configuration
public class AuthClientRunner implements CommandLineRunner {
	@Autowired
	private UserAuthConfig userAuthConfig;
	@Autowired
	private IAuthFeignApi authFeignApi;

	@Override
	public void run(String... args) throws Exception {
		Logger log = LoggerFactory.getLogger(AuthClientRunner.class);
		log.info("初始化加载用户pubKey");
		try {
			refreshUserPubKey();
		} catch (Exception e) {
			log.error("初始化加载用户pubKey失败,1分钟后自动重试!", e);
		}
	}

	@Scheduled(cron = "0 0/1 * * * ?")
	public void refreshUserPubKey() {
		ApiResult<AuthConfigInfo> authConfigInfo = authFeignApi.getAuthConfigInfo();
		if (authConfigInfo.getSuccess()) {
			AuthConfigInfo data = authConfigInfo.getData();
			this.userAuthConfig.setPubKeyByte(data.getPub())
				.setTokenHeader(data.getUserTokenHeader());
		}
	}
}