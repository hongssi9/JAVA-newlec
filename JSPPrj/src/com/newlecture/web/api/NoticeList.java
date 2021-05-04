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

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@WebServlet("/api/notice/list")
public class NoticeList extends HttpServlet { //이 클래스를 NoticeList 서블릿 이라고 한다.
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter() ;
	 
		try {
			
			String p = req.getParameter("p");
			int page = 1;
			
			if(p != null && !p.equals(""))
				page = Integer.parseInt(p);
			
			 NoticeService noticeService = new NoticeService();
			 List<Notice> list = noticeService.getList(page,"title", "");
			 
			 out.println(list);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	

}
