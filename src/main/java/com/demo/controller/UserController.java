package com.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.entity.UserInfo;
import com.demo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/showInfo/{userId}")
	public String showUserInfo(ModelMap modelmap,@PathVariable int userId){
		UserInfo userInfo = userService.getUserInfoById(userId);
		modelmap.addAttribute("userInfo", userInfo);
		return "user/showInfo";
	}
	
	@RequestMapping("/showInfos")
	@ResponseBody
	public Object showUserInfos(){
		List<UserInfo> userInfos = userService.getUsers();
		return userInfos;
	}
	
	@RequestMapping("/signin")
	@ResponseBody
	public Map<String, Object> signin(@RequestParam String email, @RequestParam String password,
			HttpServletRequest req){
		UserInfo userInfo = userService.validateUser(email , password);
		Map<String, Object> ret = new HashMap<String, Object>();
		if(userInfo != null){
			HttpSession session = req.getSession();
			session.setAttribute("user", userInfo);
			ret.put("result", true);
		}
		else{
			ret.put("result", false);
			ret.put("msg", "用户名或密码不正确");
		}
		return ret;
	}
	
	@RequestMapping("/showMusic")
	public String showMusic(){
		return "music";
	}
	
}
