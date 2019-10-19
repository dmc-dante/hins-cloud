package com.hins.cloud.auth.server.service.impl;

import com.hins.cloud.auth.server.service.AuthService;
import com.hins.cloud.auth.server.util.JwtTokenUtil;
import com.hins.cloud.common.dto.ApiResult;
import com.hins.cloud.hinsauth.common.dto.AuthParam;
import com.hins.cloud.hinsauth.common.dto.TokenResult;
import com.hins.cloud.hinsauth.common.jwt.JWTInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: dqk
 * @Date: 2019/8/14 15:01
 */
@Service
public class AuthServiceImpl implements AuthService {
	//	@Autowired
//	private IUserFeignApi userFeignApi;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	public TokenResult auth(AuthParam param) {
//		ApiResult<Map<String, Object>> validate = userFeignApi.validate(param);
		ApiResult<Map<String, Object>> validate = new ApiResult();
		validate.setData(new HashMap<>());
		validate.getData().put("id", "123");
		validate.setSuccess(true);
		if (validate.getSuccess()) {
			JWTInfo j = new JWTInfo<Object>().setId((String) validate.getData().get("id"));
			try {
				return jwtTokenUtil.createToken(j);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return null;
	}

	@Override
	public String refresh(String oldToken) {
		return null;
	}

	@Override
	public void validate(String token) {
	}
}
