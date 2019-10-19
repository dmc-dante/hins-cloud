package com.hins.cloud.common.dto;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 用来做分页查询参数（简化参数数量）
 *
 * @author duqikun
 * @date 2018-1-8
 */
public class PageParam {
	private int pageNo = 1; //页码
	private int pageSize = 10;//分页大小
	private String type;//类型参数（常用）
	private String searchKey;//搜索框参数
	private String sortProp;//排序属性名称
	private String sortOrder = "ASC";//排序方式
	Map<String, Object> others;//其他更多搜索参数统一放在一个对象里面，自己再获取

	/**
	 * @return the pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * @param pageNo the pageNo to set
	 * @return
	 */
	public PageParam setPageNo(int pageNo) {
		this.pageNo = pageNo;
		return this;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public PageParam setPageSize(int pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public PageParam setType(String type) {
		this.type = type;
		return this;
	}

	/**
	 * @return the searchKey
	 */
	public String getSearchKey() {
		return searchKey;
	}

	/**
	 * @param searchKey the searchKey to set
	 */
	public PageParam setSearchKey(String searchKey) {
		this.searchKey = searchKey;
		return this;
	}

	/**
	 * @return the sortProp
	 */
	public String getSortProp() {
		return sortProp;
	}

	/**
	 * @param sortProp the sortProp to set
	 */
	public PageParam setSortProp(String sortProp) {
		this.sortProp = sortProp;
		return this;
	}

	/**
	 * @return the sortOrder
	 */
	public String getSortOrder() {
		return sortOrder;
	}

	/**
	 * @param sortOrder the sortOrder to set
	 */
	public PageParam setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
		return this;
	}

	/**
	 * 其他更多搜索参数统一放在一个对象里面，自己再获取
	 *
	 * @return the others
	 */
	public Map<String, Object> getOthers() {
		return others;
	}

	/**
	 * @param others the others to set
	 */
	public PageParam setOthers(Map<String, Object> others) {
		this.others = others;
		return this;
	}

	public String getString(String key) {
		if (this.others == null) return "";
		return (String) this.others.get(key);
	}

	public Integer getInt(String key) {
		if (this.others == null) return null;
		return (Integer) this.others.get(key);
	}

	public List getList(String key) {
		if (this.others == null) return Collections.emptyList();
		return (List) this.others.get(key);
	}

	public <T> T get(String key) {
		if (this.others == null) return null;
		return (T) this.others.get(key);
	}
}
