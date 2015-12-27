package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.UserInfoMapper;
import com.demo.entity.UserInfo;
import com.demo.service.UserService;

@Service(value="userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserInfoMapper userInfoMapper;

	@Override
	public UserInfo getUserInfoById(int id) {
		// TODO Auto-generated method stub
		return userInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<UserInfo> getUsers() {
		// TODO Auto-generated method stub
		return userInfoMapper.selectAll();
	}

	@Override
	public int insert(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return userInfoMapper.insert(userInfo);
	}

	@Override
	public UserInfo validateUser(String email, String password) {
		// TODO Auto-generated method stub
		return userInfoMapper.validateUser(email, password);
	}

}
