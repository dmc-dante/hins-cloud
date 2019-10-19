package com.hins.cloud.common.dto;

import java.io.Serializable;

/**
 * 成对对象vo
 *
 * @author duqikun
 * @date 2017年8月7日
 */
public class Pairs<K, V> implements Serializable {
	private static final long serialVersionUID = 1L;
	private K id;
	private V name;

	public Pairs() {
	}

	public Pairs(K id, V name) {
		this.id = id;
		this.name = name;
	}

	public K getId() {
		return id;
	}

	public void setId(K id) {
		this.id = id;
	}

	public V getName() {
		return name;
	}

	public void setName(V name) {
		this.name = name;
	}
}
