package com.hins.cloud.common.exception;

/**
 * 存在多个结果型时抛出此异常
 *
 * @author dqk 2017-11-6
 */
@SuppressWarnings("serial")
public class NotUniqueException extends Exception {
	public NotUniqueException() {
		super("存在多个结果！");
	}

	public NotUniqueException(String message) {
		super(message);
	}
}
