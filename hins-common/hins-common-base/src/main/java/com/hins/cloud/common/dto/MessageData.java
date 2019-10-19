package com.hins.cloud.common.dto;

/**
 * 用来返回复杂的消息结果vo 。 可用于service 、controller、ajax之间的请求返回
 *
 * @author duqikun
 * @date 2016年11月28日
 */
public class MessageData<T> extends Message {
	private static final long serialVersionUID = -4334004705989186855L;
	private T data;

	public MessageData() {
	}

	public MessageData(boolean success) {
		super(success);
	}

	public MessageData(boolean success, String msg, T data) {
		super(success, msg);
		this.data = data;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 * @return
	 */
	public MessageData setData(T data) {
		this.data = data;
		return this;
	}
}
