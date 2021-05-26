package com.newlecture.web.controller.admin.notice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.JdbcNoticeService;
import com.sun.tools.javac.file.PathFileObject;

@WebServlet("/admin/notice/reg") //url맵핑
@MultipartConfig(
	    fileSizeThreshold = 1024*1024,
	    maxFileSize = 1024*1024*50, //50메가
	    maxRequestSize = 1024*1024*50*5 // 50메가 5개까지
	)

public class RegController extends HttpServlet{ //edit에서 보내온 두개의 데이터를 받기위한 클래스
	//controller쓰는 이유와 개념
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/admin/notice/reg.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
//----------------------------여러개 파일--------------------------------------------------		
//		String[] habs = request.getParameterValues("h"); //같은 name값을 두 개 이상 받을때는 values로 써서 배열로 받아온다		
//		System.out.println(habs[0] + "," + habs[1]); //47,48 취미 다중 선택 코드
		
		String fileNames = "";
		int fileCount = 0;
		
		Collection<Part> parts = request.getParts();
		for(Part fpart : parts) {
			if(!fpart.getName().equals("f"))
				continue;		
			if(fpart.getSize() == 0)//파일이 선택되지 않아도 올라갈수 있게하기
				continue; //제어문에는 break와 continue가있는데 break는 반복문에서 벗어나게되고 countinue 조건이 안맞으면 아래로가지않고 다시 반복문으로 돌아간다.
			
		//Part fpart = request.getPart("f");
		String fileName = fpart.getSubmittedFileName(); //전송할 파일이름
		InputStream fis = fpart.getInputStream(); //	
		fileNames += fileName + ","; //두개이상 DB에 파일을 올릴때 ,표로 구분해주기위한 코드
		fileCount++;
		//---------------------------------------
		
		ServletContext application = request.getServletContext(); 
		String path = "/upload"; //C:/proj/web/root/upload 물리경로로만 되 있어야 출력히 가능하다.
		String realpath = application.getRealPath(path); //물리경로를 얻는 코드
		String filePath = realpath + File.separator + fileName;
		FileOutputStream fos = new FileOutputStream(filePath);
		File pathFile = new File(realpath); //경로가 있는지 없는지 확인하는코드
		if(!pathFile.exists())
			pathFile.mkdir();
		
		
		System.out.println(realpath); //물리경로 얻는지 확인용
		
		byte[] buf = new byte[1024];
		int len = 0;
		
		while((len=fis.read(buf,0,1024)) >= 0 )
			fos.write(buf, 0, len);
		
		fos.flush();
		fos.close();
		fis.close();
	}
		
		fileNames = fileNames.substring(0, fileNames.length()-2); //중복파일
			
		JdbcNoticeService service = new JdbcNoticeService();
		
		
		try {
			//지금 INSERT 기능을 만드는건데 DB에서 ID값이 낫널이라 보이지않게됨
			Notice notice = new Notice();
			notice.setTitle(title); //타이틀과 컨텐트 내용을 바꾸려고 한다(수정)
			notice.setWriterId("JH");
			notice.setContent(content);
			notice.setFiles(fileNames); //fileName -> fileNames로
			service.insert(notice); //NoticeService에 업데이트
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("list"); 
		
	}

}
