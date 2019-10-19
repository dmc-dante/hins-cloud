package com.hins.cloud.common.constant;

/**
 * api请求编码和消息文字定义
 *
 * @Author: dqk
 * @Date: 2019/8/13 16:50
 */
public enum ApiResultConst {
	SUCCESS_BASE(true, 200, "请求成功"),
	SUCCESS_SAVE(true, 201, "保存成功"),
	SUCCESS_UPDATE(true, 202, "更新成功"),
	SUCCESS_DELETE(true, 203, "删除成功"),
	ERROR_BASE(false, 400, "请求失败"),
	ERROR_VALIDATE(false, 403, "权限校验失败"),
	;
	private Integer code;
	private String msg;
	private Boolean success;

	private ApiResultConst(Boolean success, Integer code, String msg) {
		this.success = success;
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public Boolean getSuccess() {
		return success;
	}
}
