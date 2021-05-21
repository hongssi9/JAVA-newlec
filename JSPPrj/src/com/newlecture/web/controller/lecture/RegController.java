package com.newlecture.web.controller.lecture;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.JdbcNoticeService;

@WebServlet("/notice/reg") //url맵핑
public class RegController extends HttpServlet{ //edit에서 보내온 두개의 데이터를 받기위한 클래스
	//controller쓰는 이유와 개념
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		JdbcNoticeService service = new JdbcNoticeService();
		
//		service.update(id, title, content);
		
		try {
			//지금 INSERT 기능을 만드는건데 DB에서 ID값이 낫널이라 보이지않게됨
			Notice notice = new Notice();
			notice.setTitle(title); //타이틀과 컨텐트 내용을 바꾸려고 한다(수정)
			notice.setWriterId("JH");
			notice.setContent(content);
			service.insert(notice); //NoticeService에 업데이트
			//service.insert(title, content)
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("list.jsp"); 
		
	}

}
