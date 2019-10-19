package com.hins.cloud.tkmybatis.entity;

import com.hins.cloud.tkmybatis.util.GenSnowFlakeId;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * 包含ID属性的基础Entity
 *
 * @Author: dqk
 * @Date: 2019/8/8 9:37
 */
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	@Id
	@KeySql(genId = GenSnowFlakeId.class)
	private Long id;

	public Long getId() {
		return id;
	}

	public BaseEntity setId(Long id) {
		this.id = id;
		return this;
	}

	@Override
	public int hashCode() {
		return (id == null) ? this.hashCode() : id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		final BaseEntity other = (BaseEntity) obj;
		Object id = getId();
		if (id == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!id.equals(other.getId())) {
			return false;
		}
		return true;
	}
}
