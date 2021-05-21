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

@WebServlet("/notice/edit") //url맵핑
public class EditController extends HttpServlet{ //edit에서 보내온 두 개의 데이터를 받기 위한 클래스
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		JdbcNoticeService service = new JdbcNoticeService();
		
//		service.update(id, title, content);
		
		Notice notice;
		try {
			notice = service.get(id);
			notice.setTitle(title); //타이틀과 컨텐트 내용을 바꾸려고 한다(수정)
			notice.setContent(content);
			service.update(notice); //NoticeService에 업데이트
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("detail.jsp?id="+id); //어떤 아이디를 업데이트 할 것인가
		
	}

}
