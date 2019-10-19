package com.hins.cloud.common.support;

import com.hins.cloud.common.constant.BaseConst;
import com.hins.cloud.common.dto.UserSession;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 当前请求线程threadlocal 数据工具类
 */
public class CurrentRequestHolder {
	public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

	public static Map<String, Object> getMap() {
		return threadLocal.get();
	}

	public static void setMap(Map<String, Object> map) {
		Map<String, Object> m = threadLocal.get();
		if (m == null) {
			threadLocal.set(map);
		} else {
			m.putAll(map);
		}
	}

	public static void set(String key, Object value) {
		Map<String, Object> map = threadLocal.get();
		if (map == null) {
			map = new HashMap<String, Object>();
			threadLocal.set(map);
		}
		map.put(key, value);
	}

	public static Object get(String key) {
		Map<String, Object> map = threadLocal.get();
		if (map == null) {
			map = new HashMap<String, Object>();
			threadLocal.set(map);
		}
		return map.get(key);
	}

	public static String getUserId() {
		return (String) get(BaseConst.CURRENT_USER_ID);
	}

	public static String getAcToken() {
		return (String) get(BaseConst.CURRENT_USER_AC_TK);
	}

	public static void setAcToken(String token) {
		set(BaseConst.CURRENT_USER_AC_TK, token);
	}

	public static void setUserId(String userId) {
		set(BaseConst.CURRENT_USER_ID, userId);
	}

	public static void setUserSessionVo(UserSession sessionVo) {
		set(BaseConst.CURRENT_USER_SESSION_KEY, sessionVo);
	}

	public static UserSession getUserSessionVo() {
		return (UserSession) get(BaseConst.CURRENT_USER_SESSION_KEY);
	}

	/**
	 * 返回当前request （HttpServletRequest）
	 *
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) get(BaseConst.CURRENT_REQUEST_KEY);
	}

	public static void setRequest(HttpServletRequest request) {
		set(BaseConst.CURRENT_REQUEST_KEY, request);
	}

	/**
	 * 移除当前的threadLocal数据
	 */
	public static void remove() {
		threadLocal.remove();
	}
}
