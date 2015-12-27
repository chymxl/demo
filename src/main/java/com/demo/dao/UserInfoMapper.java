package com.demo.dao;

import java.util.List;

import com.demo.entity.UserInfo;

public interface UserInfoMapper {
	
	UserInfo validateUser(String email, String password);
	
	UserInfo selectByPrimaryKey(int id);
	
	int deleteByPrimaryKey(int id);
	
	int insert(UserInfo userInfo);
	
	int insertSelective(UserInfo userInfo);
	
	int updateByPrimaryKeySelective(UserInfo userInfo);
	
	int updateByPrimaryKey(UserInfo userInfo);
	
	List<UserInfo> selectAll();

}
