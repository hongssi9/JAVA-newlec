package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.web.entity.Notice;

public class NoticeService {
	
	public List<Notice> getList() throws ClassNotFoundException, SQLException{
		return getList("title", "");
	}
	
	public List<Notice> getList(String field, String query) throws ClassNotFoundException, SQLException{
		List<Notice> list = new ArrayList<>();


		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE";

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111");

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql); // 서버에 있는걸 가져오는..공간
//		rs.get..공간에서 데이터를 꺼내온다

		while (rs.next()) {
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String writerId = rs.getString("writer_Id");
			Date regDate = rs.getDate("regDate");
			int hit = rs.getInt("hit");
			String files = rs.getString("files");

			Notice notice = new Notice();
			notice.setId(id);
			notice.setTitle(title);
			notice.setContent(content);
			notice.setRegDate(regDate);
			notice.setHit(hit);
			notice.setFiles(files);
			notice.setWriterId(writerId);

			list.add(notice);
		}
		rs.close();
		st.close();
		con.close(); //서버닫기!
		
		return list;
	}
}
