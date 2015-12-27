package com.demo.service;

import java.util.List;

import com.demo.entity.UserInfo;

public interface UserService {

	UserInfo getUserInfoById(int id);
	
	List<UserInfo> getUsers();
	
	int insert(UserInfo userInfo);
	
	UserInfo validateUser(String email, String password);
	
}
