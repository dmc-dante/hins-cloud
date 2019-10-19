package com.hins.cloud.common.dto;

import com.hins.cloud.common.constant.ApiResultConst;

/**
 * @Author: dqk
 * @Date: 2019/8/13 16:37
 */
public class ApiResult<T> extends MessageData<T> {
	private static final long serialVersionUID = -997755201536094786L;
	/**
	 * api 返回状态编码 code
	 */
	private Integer code;

	public ApiResult() {}

	public ApiResult(ApiResultConst c) {
		super(c.getSuccess(), c.getMsg(), null);
		this.code = c.getCode();
	}

	public ApiResult(ApiResultConst c, T data) {
		super(c.getSuccess(), c.getMsg(), data);
		this.code = c.getCode();
	}

	/**
	 * 返回默认成功的结果数据
	 *
	 * @param data
	 */
	public ApiResult(T data) {
		this(ApiResultConst.SUCCESS_BASE, data);
	}

	public Integer getCode() {
		return code;
	}

	public ApiResult setCode(Integer code) {
		this.code = code;
		return this;
	}

	@Override
	public ApiResult setData(T data) {
		super.setData(data);
		return this;
	}

	@Override
	public ApiResult setMsg(String msg) {
		super.setMsg(msg);
		return this;
	}

	@Override
	public ApiResult setSuccess(boolean success) {
		super.setSuccess(success);
		return this;
	}
}
