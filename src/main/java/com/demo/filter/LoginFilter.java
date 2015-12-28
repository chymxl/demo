package com.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.entity.UserInfo;

public class LoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		UserInfo userInfo = (UserInfo)session.getAttribute("user");
		String loginPath = req.getContextPath() + "/login";
		String url = req.getRequestURI();
		if(url.startsWith(req.getContextPath()+ "/static") || (url.equals(loginPath)) || userInfo != null
				|| url.equals(req.getContextPath() + "/user/signin")){
			chain.doFilter(request, response);
		}
		else{
			HttpServletResponse resp = (HttpServletResponse)response;
			resp.sendRedirect(req.getContextPath() + "/login");
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
