package com.hins.cloud.tkmybatis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 分布式id snowfloke算法生成配置参数
 *
 * @Author: dqk
 * @Date: 2019/8/8 14:09
 */
@Component("snowFlakeConfig")
@ConfigurationProperties(prefix = "snow-flake")
public class SnowFlakeConfig {
	/**
	 * 数据中心ID
	 */
	private Long dataCenterId;
	/**
	 * 工作节点ID
	 */
	private Long workerId;

	public Long getDataCenterId() {
		return dataCenterId;
	}

	public SnowFlakeConfig setDataCenterId(Long dataCenterId) {
		this.dataCenterId = dataCenterId;
		return this;
	}

	public Long getWorkerId() {
		return workerId;
	}

	public SnowFlakeConfig setWorkerId(Long workerId) {
		this.workerId = workerId;
		return this;
	}
}
