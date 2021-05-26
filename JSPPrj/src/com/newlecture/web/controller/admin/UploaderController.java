package com.newlecture.web.controller.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/admin/uploader")
@MultipartConfig(
	    fileSizeThreshold = 1024*1024,
	    maxFileSize = 1024*1024*50, //50메가
	    maxRequestSize = 1024*1024*500*5 // 50메가 5개까지
	)
public class UploaderController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String p = request.getParameter("p");
		
		Part fpart = request.getPart("f");
		String fileName = fpart.getSubmittedFileName(); //전송할 파일이름
		InputStream fis = fpart.getInputStream(); //	
		
		ServletContext application = request.getServletContext(); 
		
		String path = "/upload"; //C:/proj/web/root/upload 물리경로로만 되 있어야 출력히 가능하다.
		if(p != null && !p.equals(""))
			path = p;
		
		String realpath = application.getRealPath(path); //물리경로를 얻는 코드
		
		File pathFile = new File(realpath); //경로가 있는지 없는지 확인하는코드
		if(!pathFile.exists())
			pathFile.mkdir();
		
		String filePath = realpath + File.separator + fileName;
		FileOutputStream fos = new FileOutputStream(filePath);
		
		System.out.println(realpath); //물리경로 얻는지 확인용
		
		byte[] buf = new byte[1024];
		int len = 0;
		
		while((len=fis.read(buf,0,1024)) >= 0 )
			fos.write(buf, 0, len);
		
		fos.flush();
		fos.close();
		fis.close();
	}

}
