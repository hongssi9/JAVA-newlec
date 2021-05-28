package com.newlecture.web.filter; //인증관련 필터 클래스

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*") // 필터 장착~
public class AuthenticationFilter implements Filter { // 로그인이 안되면 인덱스페이지로 오는 필터도 만들어보자~

	// 값을 바꾸게하지못하게 final
	private static final String[] authRequiredURLs = { "/admin/*", "/member/*" // 두개 페이지만 조건을 주겠다.
	};

	private boolean isAuthRequired(String uri) { //조건을 넣어주고싶은게 추가되면 위아래 계속 추가해야하니까
												//반복문을 넣어서 걸리는것만
		
		boolean required = false;
		
		for(String autoPath : authRequiredURLs) {
			
			if(uri.startsWith("/member/login"))
				return false;
				
			required = uri.startsWith(autoPath);
		
			if(required)
				break;
		}
		
		return required;
		
	}
	
	@Override				//얘는 인터페이스 서블릿
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		
		HttpServletRequest req = (HttpServletRequest)request; //얘는 클래스 서블릿
		HttpServletResponse resp = (HttpServletResponse)response;
		String uri = req.getRequestURI();
		
		if(uri.startsWith("/admin/") || uri.startsWith("/member/")){ //주소시작이 /admin , /member가 들어가면 조건이 걸리도록
		//만약에 현재 사용자가 login 프로세스를 통해서 인증이 되지 않았다면
		HttpSession session = req.getSession();
		String uid = (String)session.getAttribute("uid"); //담기는건 오브젝트이기때문에 형변환
		//인증하고 오세요(로그인페이지로)
		if(uid == null) {
			resp.sendRedirect("/member/login?returnURL="+uri);
			return;
			}
		}
		
		chain.doFilter(request, response); //인증해주는 코드
		
	}

}
