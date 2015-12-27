package com.demo.entity;

import java.util.List;

public class UserInfo {

	private int id;
	private String uname;
	private int unumber;
	private String email;
	private String password;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private List<CourseInfo> courseInfos;

	public List<CourseInfo> getCourseInfos() {
		return courseInfos;
	}

	public void setCourseInfos(List<CourseInfo> courseInfos) {
		this.courseInfos = courseInfos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getUnumber() {
		return unumber;
	}

	public void setUnumber(int unumber) {
		this.unumber = unumber;
	}

}
