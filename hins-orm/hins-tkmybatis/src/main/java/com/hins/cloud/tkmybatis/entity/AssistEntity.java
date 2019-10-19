package com.hins.cloud.tkmybatis.entity;

import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.Version;

import javax.persistence.Column;
import java.util.Date;

/**
 * 包含多种基础常用属性的entity基类
 *
 * @Author: dqk
 * @Date: 2019/8/8 9:46
 */
public class AssistEntity extends BaseEntity {
	private static final long serialVersionUID = -8475517769070715166L;
	/**
	 * 版本号
	 */
	@Version
	private Integer version;
	/**
	 * 创建人
	 */
	private String creator;
	/**
	 * 创建人ID
	 */
	@Column(name = "creator_id")
	private Long creatorId;
	/**
	 * 创建时间
	 */
	@Column(name = "created_time")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdTime;
	/**
	 * 最近操作人
	 */
	@Column(name = "last_operator")
	private String lastOperator;
	/**
	 * 最后操作人ID
	 */
	@Column(name = "last_operator_id")
	private Long lastOperatorId;
	/**
	 * 更新时间
	 */
	@Column(name = "update_time")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

	public Integer getVersion() {
		return version;
	}

	public AssistEntity setVersion(Integer version) {
		this.version = version;
		return this;
	}

	public String getCreator() {
		return creator;
	}

	public AssistEntity setCreator(String creator) {
		this.creator = creator;
		return this;
	}

	public Long getCreatorId() {
		return creatorId;
	}

	public AssistEntity setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
		return this;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public AssistEntity setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
		return this;
	}

	public String getLastOperator() {
		return lastOperator;
	}

	public AssistEntity setLastOperator(String lastOperator) {
		this.lastOperator = lastOperator;
		return this;
	}

	public Long getLastOperatorId() {
		return lastOperatorId;
	}

	public AssistEntity setLastOperatorId(Long lastOperatorId) {
		this.lastOperatorId = lastOperatorId;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public AssistEntity setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}
}
