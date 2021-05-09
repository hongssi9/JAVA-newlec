package com.newlecture.web.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;
import com.newlecture.web.service.NoticeService_st;

@WebServlet("/api/notice/list")
public class NoticeList_st extends HttpServlet { //이 클래스를 NoticeList 서블릿 이라고 한다.
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NoticeService_st service = new NoticeService_st(); //NoticeService객체화 해서 사용하기
		List<Notice> list = service.getNoticeList(); //NoticeService에 있는 getList를 가져온다
		
		req.setAttribute("list",list);
		
		req
		.getRequestDispatcher("/WEB-INF/view/notice/list.jsp")
		.forward(req,resp);
		
	}
	

}
