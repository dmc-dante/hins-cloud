package com.hins.cloud.common.dto;

import java.io.Serializable;

/**
 * 用来返回一般的消息结果vo 。 可用于service 、controller、ajax之间的请求返回
 *
 * @author duqikun
 * @date 2016年11月28日
 */
public class Message implements Serializable {
	private static final long serialVersionUID = -3916378588596301116L;
	/**
	 * 返回消息
	 */
	private String msg;
	/**
	 * 返回結果 ture | false
	 */
	private boolean success;

	public Message() {
	}

	public Message(boolean success) {
		this.success = success;
	}

	public Message(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}

	/**
	 * 消息明细
	 *
	 * @return
	 */
	public String getMsg() {
		return this.msg;
	}

	/**
	 * 返回結果
	 *
	 * @return true 成功，false 失敗
	 */
	public boolean getSuccess() {
		return this.success;
	}

	/**
	 * 消息明细
	 *
	 * @param msg
	 * @return
	 */
	public Message setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	/**
	 * 返回結果
	 *
	 * @param success
	 * @return
	 */
	public Message setSuccess(boolean success) {
		this.success = success;
		return this;
	}
}
