package com.newlecture.web.controller.admin.notice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.JdbcNoticeService;

@WebServlet("/admin/notice/detail")
public class DetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id_ = request.getParameter("id"); //QueryString으로 입력받을 값을 가져오기 위해 선언
			int id = Integer.parseInt(id_); //getParameter는 문자열로만 받아오니까 다시 정수로 바꾼다.
			//int id = Interger.parseInt(request.hetParameter("id"); 로 한줄로 생략 가능할거같다.

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
			
			request.getRequestDispatcher("/WEB-INF/view/admin/notice/detail.jsp").forward(request, response); 

	}

}
