package com.hins.cloud.auth.client.hystrix;

import com.hins.cloud.common.support.CurrentRequestHolder;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import com.netflix.hystrix.strategy.HystrixPlugins;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariable;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariableLifecycle;
import com.netflix.hystrix.strategy.eventnotifier.HystrixEventNotifier;
import com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook;
import com.netflix.hystrix.strategy.metrics.HystrixMetricsPublisher;
import com.netflix.hystrix.strategy.properties.HystrixPropertiesStrategy;
import com.netflix.hystrix.strategy.properties.HystrixProperty;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自定义扩展代理hystrix的策略
 * 解决hystrix策略未thread时无法获取当前会话request的问题
 *
 * @Author: dqk
 * @Date: 2019/8/20 16:39
 */
public class RequestAttributeHystrixConcurrencyStrategy extends HystrixConcurrencyStrategy {
	private static final Log log = LogFactory
		.getLog(RequestAttributeHystrixConcurrencyStrategy.class);
	private HystrixConcurrencyStrategy delegate;

	public RequestAttributeHystrixConcurrencyStrategy() {
		try {
			this.delegate = HystrixPlugins.getInstance().getConcurrencyStrategy();
			if (this.delegate instanceof RequestAttributeHystrixConcurrencyStrategy) {
				// Welcome to singleton hell...
				return;
			}
			HystrixCommandExecutionHook commandExecutionHook = HystrixPlugins
				.getInstance().getCommandExecutionHook();
			HystrixEventNotifier eventNotifier = HystrixPlugins.getInstance()
				.getEventNotifier();
			HystrixMetricsPublisher metricsPublisher = HystrixPlugins.getInstance()
				.getMetricsPublisher();
			HystrixPropertiesStrategy propertiesStrategy = HystrixPlugins.getInstance()
				.getPropertiesStrategy();
			logCurrentStateOfHystrixPlugins(eventNotifier, metricsPublisher,
				propertiesStrategy);
			HystrixPlugins.reset();
			HystrixPlugins.getInstance().registerConcurrencyStrategy(this);
			HystrixPlugins.getInstance()
				.registerCommandExecutionHook(commandExecutionHook);
			HystrixPlugins.getInstance().registerEventNotifier(eventNotifier);
			HystrixPlugins.getInstance().registerMetricsPublisher(metricsPublisher);
			HystrixPlugins.getInstance().registerPropertiesStrategy(propertiesStrategy);
		} catch (Exception e) {
			log.error("Failed to register Sleuth Hystrix Concurrency Strategy", e);
		}
	}

	private void logCurrentStateOfHystrixPlugins(HystrixEventNotifier eventNotifier,
		HystrixMetricsPublisher metricsPublisher,
		HystrixPropertiesStrategy propertiesStrategy) {
		if (log.isDebugEnabled()) {
			log.debug("Current Hystrix plugins configuration is ["
				+ "concurrencyStrategy [" + this.delegate + "]," + "eventNotifier ["
				+ eventNotifier + "]," + "metricPublisher [" + metricsPublisher + "],"
				+ "propertiesStrategy [" + propertiesStrategy + "]," + "]");
			log.debug("Registering Sleuth Hystrix Concurrency Strategy.");
		}
	}

	@Override
	public <T> Callable<T> wrapCallable(Callable<T> callable) {
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		return new WrappedCallable<>(callable, requestAttributes, CurrentRequestHolder.getMap());
	}

	@Override
	public ThreadPoolExecutor getThreadPool(HystrixThreadPoolKey threadPoolKey,
		HystrixProperty<Integer> corePoolSize,
		HystrixProperty<Integer> maximumPoolSize,
		HystrixProperty<Integer> keepAliveTime, TimeUnit unit,
		BlockingQueue<Runnable> workQueue) {
		return this.delegate.getThreadPool(threadPoolKey, corePoolSize, maximumPoolSize,
			keepAliveTime, unit, workQueue);
	}

	@Override
	public ThreadPoolExecutor getThreadPool(HystrixThreadPoolKey threadPoolKey,
		HystrixThreadPoolProperties threadPoolProperties) {
		return this.delegate.getThreadPool(threadPoolKey, threadPoolProperties);
	}

	@Override
	public BlockingQueue<Runnable> getBlockingQueue(int maxQueueSize) {
		return this.delegate.getBlockingQueue(maxQueueSize);
	}

	@Override
	public <T> HystrixRequestVariable<T> getRequestVariable(
		HystrixRequestVariableLifecycle<T> rv) {
		return this.delegate.getRequestVariable(rv);
	}

	static class WrappedCallable<T> implements Callable<T> {
		private final Callable<T> target;
		private final RequestAttributes requestAttributes;
		private final Map<String, Object> currentRequestHolderMap;//保存封装的当前threadLocal会话对象

		public WrappedCallable(Callable<T> target, RequestAttributes requestAttributes, Map<String, Object> currentRequestHolderMap) {
			this.target = target;
			this.requestAttributes = requestAttributes;
			this.currentRequestHolderMap = currentRequestHolderMap;
		}

		@Override
		public T call() throws Exception {
			try {
				RequestContextHolder.setRequestAttributes(requestAttributes);
				CurrentRequestHolder.setMap(currentRequestHolderMap);
				return target.call();
			} finally {
				RequestContextHolder.resetRequestAttributes();
			}
		}
	}
}
