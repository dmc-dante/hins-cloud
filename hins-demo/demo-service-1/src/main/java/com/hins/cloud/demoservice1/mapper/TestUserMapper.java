package com.hins.cloud.demoservice1.mapper;

import com.hins.cloud.demoservice1.entity.TestUser;
import com.hins.cloud.tkmybatis.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Author: dqk
 * @Date: 2019/8/8 15:12
 */
@Mapper
@Component
public interface TestUserMapper extends BaseMapper<TestUser> {
}
