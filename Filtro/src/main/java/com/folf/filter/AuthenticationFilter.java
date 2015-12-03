package com.folf.filter;

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

public class AuthenticationFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		System.out.println("Requested Resource::"+uri);
		HttpSession session = req.getSession(false);
		if(session == null && !(uri.endsWith("html") || uri.endsWith("LoginServlet"))){
			res.sendRedirect("index.html");
		}else{
			chain.doFilter(request, response);
		}		
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("AuthenticationFilter inicializado");
	}	
	public void destroy() {
		System.out.println("AuthenticationFilter stopped");
	}
}