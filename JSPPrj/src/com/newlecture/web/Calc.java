package com.newlecture.web;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class Calc extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		// 1. ��/��� ������ �߰��Ǿ���..	
		int x = 0;
		int y = 0;
		int result = 0;
		String x_ = null;
		String y_ = null;		
		String r_ = req.getParameter("r");
		
		if(r_ != null)
			result = Integer.parseInt(r_);
		
		PrintWriter out = resp.getWriter();
		
		// ����/���� -> ��� -> ���ڱ�� -> �ڵ�ȭ�� ���ڱ�� -> AI -> ����->      
		// Jasper
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<section>");
		out.write("		<h1>����</h1>");
		out.write("		<div>");
		
		if(x_ != null)
			out.write("			<div>"+x+"+"+y+"=</div>");
		
		out.write("			<form action=\"/add\" method=\"post\">");
		out.write("				<input type=\"text\" name=\"x\">+<input type=\"text\" name=\"y\"><br>");
		out.write("				<input type=\"submit\" value=\"����\"><span>"+result+"</span>");
		out.write("			</form>");
		out.write("		</div>");
		out.write("	</section>");
		out.write("</body>");
		out.write("</html>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. ��/��� ������ �߰��Ǿ���..
		int x = 0;
		int y = 0;
		int asdf = 0;
		String x_ = null;
		String y_ = null;
		
		//if(req.getMethod().equals("POST")){
		System.out.println("post");
		
		x_ = req.getParameter("x");
		if(x_ != null && !x_.equals(""))
			x = Integer.parseInt(x_);
		
		y_ = req.getParameter("y");
		if(x_ != null && !x_.equals(""))
			y = Integer.parseInt(y_);
		
		asdf = x+y;

		// doGet ��û�� �ϴ� ���� �� ȿ�����̴�.
		// doGet(req, resp);
		resp.sendRedirect("/add?r="+asdf);
		
		// get ��û�ϸ鼭 get�� ó���ϴ� �������� ���� ���� �� �Ǵ� ���¸� ������ �� �ִ� ����� �ʿ��ϴ�.
		// 1. ������ �̿��ϴ� ���
		// 2. ������ �����(Application/Session/Request/Cookie/..)�� �̿��ϴ� ���
		// 3. QueryString�� �̿��ϴ� ���
		//}
	}
		
	/*
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
				
		
		// 1. ��/��� ������ �߰��Ǿ���..		
		int x = 0;
		int y = 0;
		int result = 0;
		String x_ = null;
		String y_ = null;
		
		if(req.getMethod().equals("POST")){
			System.out.println("calc");
			
			x_ = req.getParameter("x");
			if(x_ != null && !x_.equals(""))
				x = Integer.parseInt(x_);
			
			y_ = req.getParameter("y");
			if(x_ != null && !x_.equals(""))
				y = Integer.parseInt(y_);
			
			result = x+y;
		}
		
		// 1. ����� ����� �� �ֵ��� ���� UI�� ����ϱ�
		// 2. �ѱ� �������� �ذ��ϱ�
		// 3. ���⿡�� ����� ��� �� �ܿ� ����ߴ� ����ĵ� �Բ� �����ֱ�
		// 4. POST ��û�� �⺻ ��
		// 5. GET��û�� POST�� ���ؿ� �ڵ� �и��ϱ�
		
		// ���繫�� : �ΰ������� �߱� �ޱ� -> �ΰ������� ���� �Խ��ϴ�.(GET)->�Է���->����(POST)
		
		// ȸ������� �ּ��� / �˻� ������ �ּ��� / .... (GET)
		
		// ������ �������� ����� �ڵ� : �� �ڵ�� ������� ����� : ������ ���� : ��������
		PrintWriter out = resp.getWriter();				
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<section>");
		out.write("		<h1>����</h1>");
		out.write("		<div>");
		
		if(x_ != null)
			out.write("			<div>"+x+"+"+y+"=</div>");
		
		out.write("			<form action=\"/add\" method=\"post\">");
		out.write("				<input type=\"text\" name=\"x\">+<input type=\"text\" name=\"y\"><br>");
		out.write("				<input type=\"submit\" value=\"����\"><span>"+result+"</span>");
		out.write("			</form>");
		out.write("		</div>");
		out.write("	</section>");
		out.write("</body>");
		out.write("</html>");
		
//		[iso-8859-1]	-  'a'(97)	- '��'(3432 | 332) - 0000032
//		[ascii][utf-8]	-  'a'(97)	- '��'(3432332)
//		[ascii][euc-kr] -  'a'(97)	- '��'(15323) / '�s'(3432332)
				
		//add?x=3&y=5 // ���� GET ��û������ ���� �����ϰ� ����� ��� ��û
		
		//add -> �Է��� ��û(GET)
		//add*submit-> ���� ��û(POST)
		
//		//resp.getOutputStream()
//		resp.getWriter().println(x+y);
//		// 2. ������ ���� �� �� ����. ��Ĺ�� ���ؼ� ����ǵ��� �Ѵ�.
		
		super.service(req, resp);
	}
	*/
}
