package com.harshit.sms;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	public void init(FilterConfig con) throws ServletException{}
	
	public void destroy() {}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) req).getSession(false);
		if(session!=null && session.getAttribute("log").equals("in")) {
			chain.doFilter(req, res);
		}
		else {
			PrintWriter out = res.getWriter();
			out.println("Need to Login First");
			req.getRequestDispatcher("login").include(req, res);
		}
	}
}
