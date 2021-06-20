package com.newlecture.web.controller.admin.notice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.JdbcNoticeService;
@WebServlet("/admin/notice/list")
public class ListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String p = request.getParameter("p");
	   	String f = request.getParameter("f");
	   	String q = request.getParameter("q");
	   		
	   	System.out.println(p);
	   	System.out.println(f);
	   	System.out.println(q);
	   	
	   	// 변수 초기화 : 기본 값을 설정하는 것.
	   	int page = 1;
	   	String field = "title";
	   	String query = "";
	   	
	   	if(p != null && !p.equals(""))
	   		page = Integer.parseInt(p);
	   	
	   	if(f != null && !f.equals(""))
	   		field = f;
	   	
	   	if(q != null && !q.equals(""))
	   		query = q;
	   	
	   	
	    JdbcNoticeService noticeService = new JdbcNoticeService();		
	   	List<Notice> list = noticeService.getList(page, field, query);
	   	int count = 0;
	   	
	   	try {
			count = noticeService.getCount(field, query);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   	
	   	// 포워딩은 여러분들이 하는 걸로다가.... 남기고..
	   	// 1. 데이터 심기(Model 데이터)
	   	request.setAttribute("list", list);
	   	request.setAttribute("count", count);
	   	// 2. 포워딩 하기
	   	request.getRequestDispatcher("/WEB-INF/view/admin/notice/list.jsp").forward(request, response);
	}
}