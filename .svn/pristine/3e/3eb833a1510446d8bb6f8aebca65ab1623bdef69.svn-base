package com.hins.cloud.demoservice1.entity;

import com.hins.cloud.tkmybatis.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: dqk
 * @Date: 2019/8/8 15:04
 */
@Table(name = "test_user")
public class TestUser extends BaseEntity {
	private static final long serialVersionUID = -4335654380152221462L;
	@Column(name = "name")
	private String name;
	@Column(name = "sex")
	private String sex;
	@Column(name = "birthday")
	private Date birthday;

	public String getName() {
		return name;
	}

	public TestUser setName(String name) {
		this.name = name;
		return this;
	}

	public String getSex() {
		return sex;
	}

	public TestUser setSex(String sex) {
		this.sex = sex;
		return this;
	}

	public Date getBirthday() {
		return birthday;
	}

	public TestUser setBirthday(Date birthday) {
		this.birthday = birthday;
		return this;
	}
}
