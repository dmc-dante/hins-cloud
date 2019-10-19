package com.hins.cloud.common.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUtils {
	/**
	 * 将对象列表转化成HashMap<br/>
	 * 比如有对象 Person{id, name} 有 id、name两个属性<br/>
	 * 调用方式就是listToMap(List<Person> list, "id")<br/>
	 *
	 * @param list     对象列表
	 * @param keyField 将要作为hashmap的key的 对象的属性字段名称
	 * @return
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public static Map listToMap(List<?> list, String keyField) {
		Map map = new HashMap<Object, Object>();
		for (Object object : list) {
			try {
				Field field = null;
				try {
					field = object.getClass().getDeclaredField(keyField);
				} catch (Exception e) {
					field = object.getClass().getSuperclass().getDeclaredField(keyField);
				}
				field.setAccessible(true);
				Object key = field.get(object);
				map.put(key, object);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return map;
	}

	/**
	 * 将对象列表按照keyFileid，进行hashmap的分组，转换成Map<Object,List<Object>>
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public static Map listChangeMapListByField(List<?> list, String keyFieid) {
		Map map = new HashMap<Object, Object>();
		for (Object object : list) {
			try {
				Field field = null;
				try {
					field = object.getClass().getDeclaredField(keyFieid);
				} catch (Exception e) {
					field = object.getClass().getSuperclass().getDeclaredField(keyFieid);
				}
				field.setAccessible(true);
				Object key = field.get(object);
				if (map.containsKey(key)) {
					List<Object> temp = (List<Object>) map.get(key);
					temp.add(object);
					map.put(key, temp);
				} else {
					List<Object> temp = new ArrayList<Object>();
					temp.add(object);
					map.put(key, temp);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return map;
	}

	/*public static Map listToMap(List<? extends AbstractEntity> list) {
		Map map = new HashMap<Object, Object>();
		for (AbstractEntity object : list) {
			Object key = object.getId();
			map.put(key, object);
		}
		return map;
	}

	public static Map voListToMap(List<? extends BaseVo> list) {
		Map map = new HashMap<Object, Object>();
		for (BaseVo object : list) {
			Object key = object.getId();
			map.put(key, object);
		}
		return map;
	}*/
}
