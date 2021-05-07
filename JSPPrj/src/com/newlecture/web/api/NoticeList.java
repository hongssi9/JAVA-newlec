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

@WebServlet("/api/notice/list")
public class NoticeList extends HttpServlet { //이 클래스를 NoticeList 서블릿 이라고 한다.
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter() ;
	 
		try {
			
			String p = req.getParameter("p");
			String f = req.getParameter("f");
			String q = req.getParameter("q"); //데이터 받아오기~
			
			int page = 1;
			String field = "title";
			String query = "";
			
			if(p != null && !p.equals("")) //값이 널인지 체크
				page = Integer.parseInt(p);
			
			if(f != null && !f.equals(""))
				field = f;
			
			if(q != null && !q.equals(""))
				query = q;
			
			 NoticeService noticeService = new NoticeService();
			 List<Notice> list = noticeService.getList(page,field,query);
			 
			 Thread.sleep(3000);
			 
			 Gson gson = new Gson();
			 
			 String json = gson.toJson(list);
			 
//			 String json = "[";
			 
//			 json += String.format("{\"id\":..... , null);
			 
			 out.println(json); //[ , , , , ]구조가 동일해서 운좋게 저렇게 만들어서 출력해준거임list가 배열이라!
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	

}
