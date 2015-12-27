package com.demo.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.demo.entity.UserInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml", "classpath:spring-mybatis.xml"})
public class TestUserService {
	
	private static final Logger LOGGER = Logger.getLogger(TestUserService.class);
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testQueryById(){
		UserInfo userInfo = userService.getUserInfoById(1);
		LOGGER.info(JSON.toJSON(userInfo));
	}
	
	@Test
	public void testQueryAll(){
		List<UserInfo> userInfos = userService.getUsers();
		LOGGER.error(userInfos);
	}
	
	@Test
	public void testInsert(){
		UserInfo userInfo = new UserInfo();
		userInfo.setId(2);
		userInfo.setUname("jack");
		userInfo.setUnumber(2);
		int ret = userService.insert(userInfo);
		System.out.println(ret);
	}

}
