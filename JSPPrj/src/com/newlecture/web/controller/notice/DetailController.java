package com.newlecture.web.controller.notice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.JdbcNoticeService;

@WebServlet("/notice/detail")
public class DetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id_ = request.getParameter("id");
			int id = Integer.parseInt(id_);

			JdbcNoticeService noticeService = new JdbcNoticeService();
			Notice notice = null;
			try {
				notice = noticeService.get(id);
			} catch (ClassNotFoundException e) {		
				e.printStackTrace();
			} catch (SQLException e) {			
				e.printStackTrace();
			} 
			request.setAttribute("notice",notice); 
			
			request.getRequestDispatcher("detail.jsp").forward(request, response); 

	}

}
