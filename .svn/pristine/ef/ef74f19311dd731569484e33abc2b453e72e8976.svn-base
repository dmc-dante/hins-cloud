package com.hins.cloud.common.handler;

import com.hins.cloud.common.constant.ApiResultConst;
import com.hins.cloud.common.dto.ApiResult;
import com.hins.cloud.common.exception.TokenValidateException;
import com.hins.cloud.common.log.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by ace on 2017/9/8.
 */
@ControllerAdvice("com.hins.cloud")
@ResponseBody
public class GlobalExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(TokenValidateException.class)
	public ApiResult clientTokenExceptionHandler(HttpServletResponse response, TokenValidateException ex) {
		response.setStatus(403);
		logger.error(ex.getMessage(), ex);
		return new ApiResult(ApiResultConst.ERROR_VALIDATE).setMsg(ex.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public ApiResult otherExceptionHandler(HttpServletResponse response, Exception ex) {
//		response.setStatus(500);
		logger.error(ex.getMessage(), ex);
		return new ApiResult(ApiResultConst.ERROR_BASE).setMsg(ex.getMessage());
	}
}
