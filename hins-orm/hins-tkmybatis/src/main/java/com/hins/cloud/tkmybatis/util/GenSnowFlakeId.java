package com.hins.cloud.tkmybatis.util;

import com.hins.cloud.common.log.LoggerFactory;
import com.hins.cloud.common.support.BeanFactory;
import com.hins.cloud.common.util.IdWorker;
import com.hins.cloud.tkmybatis.config.SnowFlakeConfig;
import tk.mybatis.mapper.genid.GenId;

/**
 * tkmybatis主键生成的策略实现类
 *
 * @Author: dqk
 * @Date: 2019/8/8 11:40
 */
public class GenSnowFlakeId implements GenId<Long> {
	private static volatile IdWorker idWorker;

	@Override
	public Long genId(String table, String column) {
		return getWorker().nextId();
	}

	private IdWorker getWorker() {
		if (idWorker == null) {
			synchronized (GenSnowFlakeId.class) {
				if (idWorker == null) {
					SnowFlakeConfig snowFlakeConfig = BeanFactory.getBean(SnowFlakeConfig.class);
					if (snowFlakeConfig.getDataCenterId() == null) {
						LoggerFactory.getLogger(this.getClass()).warn("未配置生成分布式id参数：snow-flake.data-center-id，默认设为1");
						snowFlakeConfig.setDataCenterId(1L);
					}
					if (snowFlakeConfig.getWorkerId() == null) {
						LoggerFactory.getLogger(this.getClass()).warn("未配置生成分布式id参数：snow-flake.worker-id，默认设为1");
						snowFlakeConfig.setWorkerId(1L);
					}
					idWorker = new IdWorker(snowFlakeConfig.getDataCenterId(), snowFlakeConfig.getWorkerId(), 1);
				}
			}
		}
		return idWorker;
	}
}