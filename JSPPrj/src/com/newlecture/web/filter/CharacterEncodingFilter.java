package com.newlecture.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*") //들어오는 모든 서블릿에 관여를 하라는 코드
public class CharacterEncodingFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		//먼저실행되는곳
		chain.doFilter(request, response); //인증해주는 코드 이게있어야 적용
		//나중에 실행되는곳
		
		
	} //UTF-8을 위한 필터 //servlet필터로 골라야한다.

}
