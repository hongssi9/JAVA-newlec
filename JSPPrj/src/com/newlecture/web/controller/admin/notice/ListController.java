package com.newlecture.web.controller.admin.notice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.JdbcNoticeService;
@WebServlet("/admin/notice/list")
public class ListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String f = request.getParameter("f"); //list.jsp 에있는 (String field, String query)로 전달된다.
		String q = request.getParameter("q");
		String p = request.getParameter("p"); //페이지
		
		System.out.println(f);
		System.out.println(q);
		System.out.println(p);
		
		//변수 초기화 : 기본 값을 설정하는 것
		int page = 1; //페이지 수는 정수로 받아야 하기 때문에 page빨간줄이유 : page는 내장변수가 이미 어디서 쓰이고있어서
		String field = "title";
		String query = "";
		
		if(p != null && !p.equals(""))
			page = Integer.parseInt(p);
		
		if(f != null && f.equals("")) //null도 아니고 빈 문자도 아니면
			field = f;
		
		if(q != null && !q.equals(""))
			query = q;
		
	   JdbcNoticeService noticeService = new JdbcNoticeService();
	   List<Notice> list = null;
	   int count = 0;
	try {
		list = noticeService.getList(page, field, query);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	try {
		count = noticeService.getCount(field, query);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	   
	   //1.데이터 심기(model 데이터)
	   request.setAttribute("list", list);
	   request.setAttribute("count", count);
	   //2. 포워딩 하기
	   request.getRequestDispatcher("/WEB-INF/view/admin/notice/list.jsp").forward(request, response);
	}

}
