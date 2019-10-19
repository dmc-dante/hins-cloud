package com.hins.cloud.common.support;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: dqk
 * @Date: 2019/8/7 16:47
 */
public final class BeanFactory {
	/**
	 * 获取spring bean
	 *
	 * @param beanName
	 * @return spring bean
	 */
	public static Object getBean(String beanName) {
		return SpringContextHolder.getApplicationContext().getBean(beanName);
	}

	/**
	 * 获取spring bean
	 *
	 * @param <T>   spring bean class类型
	 * @param clazz spring bean class类型
	 * @return spring bean
	 */
	public static <T> T getBean(Class<T> clazz) {
		return SpringContextHolder.getApplicationContext().getBean(clazz);
	}
//	/**
//	 * 获取spring bean
//	 *
//	 * @param <T>   spring bean class类型
//	 * @param clazz spring bean class类型
//	 * @return spring bean
//	 *//*
//	@SuppressWarnings("unchecked")
//	public static <T> List<T> getBean(Class<T> clazz) {
//		List<T> list = new ArrayList<T>();
//		for (String beanName : SpringContextHolder.getApplicationContext().getBeanDefinitionNames()) {
//			Object bean = getBean(beanName);
//			if (bean == null) {
//				continue;
//			}
//			for (Class<?> current : ClassUtils.getSupperClass(bean.getClass())) {
//				if (current == clazz) {
//					list.add((T) bean);
//					break;
//				}
//			}
//		}
//		return list;
//	}*/

	/**
	 * 获取spring的所有bean以及bean对应的class
	 *
	 * @return spring的所有bean以及bean对应的class
	 */
	public static Map<String, Class<?>> getBeanName() {
		Map<String, Class<?>> map = new HashMap<String, Class<?>>();
		for (String beanName : SpringContextHolder.getApplicationContext().getBeanDefinitionNames()) {
			map.put(beanName, SpringContextHolder.getApplicationContext().getType(beanName));
		}
		return map;
	}
}
