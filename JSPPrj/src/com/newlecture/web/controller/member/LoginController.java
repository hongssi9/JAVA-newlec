package com.newlecture.web.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newlecture.web.entity.Member;
import com.newlecture.web.service.MemberService;

@WebServlet("/member/login")
public class LoginController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String returnURL = request.getParameter("returnURL");
		
		//페이지를 만들어서 줘야 하는 입장
		request.getRequestDispatcher("/WEB-INF/view/member/login.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("username"); //submit해서 넘어온 값을 받아오는 파라매터
		String password = request.getParameter("password");
		String returnURL = request.getParameter("returnURL");

		//데이터베이스에서 회원 데이터를 가져와서 회원 인증을 한다.
		MemberService memberService = new MemberService();
		Member member = memberService.getByNicName(userName);
		
		if(member == null) {
			//회원이 없을경우
			//에러 메시지를 보여주거나 에러를 jsp에서 보여주게 한다.
			response.sendRedirect("login?error=1");
			return;
		}
		else if(!member.getPwd().equals(password)) {
			//비밀번호가 일치하지 않을 경우
			//에러 메시지를 보여주거나 에러를 jsp에서 보여주게 한다.
			response.sendRedirect("login?error=1");
			return; //리턴을 안쓰면 다른 에러 메시지와 충돌이 나게 된다.
			
		}
		
			//인증이 성공하면
			//session 에 인증 정보를 기록한다.
			HttpSession session = request.getSession();
			session.setAttribute("uid", userName);
			
		if(returnURL != null && !returnURL.equals("")) { //비어있지않다면..으로 비교해야한다
			response.sendRedirect(returnURL);
			return;
		}
		
		// 제출된 데이터를 처리하고 다른 URL 가야 하는 입장
		// 기본 URL
			response.sendRedirect("/index");
			
				
		}
		
		
	}

