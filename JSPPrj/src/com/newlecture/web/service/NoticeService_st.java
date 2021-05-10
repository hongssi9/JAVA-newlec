//package com.newlecture.web.service;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import com.newlecture.web.entity.Notice;
//
//public class NoticeService_st {
//	public List<Notice> getNoticeList() throws SQLException{ 
//			
//		return getNoticeList("title","",1);
//		}
//	
//	public List<Notice> getNoticeList(int page) throws SQLException{
//		
//		return getNoticeList("title","",page);
//	}
//	
//	public List<Notice> getNoticeList(String field, String query, int page) throws SQLException{ //게시글 목록 정렬해서
//		List<Notice> list = new ArrayList<>(); //1. list라는 배열 객체를 만들었다.
//		
//		String sql = "SELECT * FROM (" +
//				"	SELECT ROWNUM NUM, N.* " +  		//값이 문자열일 경우 쿼리문에 바로 꽂아주자
//				"	FROM (SELECT * FROM NOTICE WHERE "+field+" LIKE ? ORDER BY REGDATE DESC) N" + 
//				")"+
//				"WHERE NUM BETWEEN ? AND ?";
//		
//		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
//		
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//			Connection con = DriverManager.getConnection(url, "NEWLEC", "11111");
//			//Statement st = con.createStatement();
//			PreparedStatement st = con.prepareStatement(sql); //쿼리문에 물음표가 들어갔을때
//			st.setString(1, "%"+query+"%"); //검색어 만들기
//			st.setInt(2, 1+(page-1)*10);//값이면 이렇게
//			st.setInt(3, 1+(page-1)*10);
//			ResultSet rs = st.executeQuery(); // 서버에 있는걸 가져오는..공간
//			
//			while (rs.next()) { //2. 조건문으로 DBMS있는 데이터를 찾는다
//				int id = rs.getInt("id");
//				String title = rs.getString("title");
//				String content = rs.getString("content");
//				String writerId = rs.getString("writer_Id");
//				Date regDate = rs.getDate("regDate");
//				int hit = rs.getInt("hit");
//				String files = rs.getString("files");
//
//				Notice notice = new Notice();//3. 가져온 데이터를 notice에 담아준다.
//				notice.setId(id);
//				notice.setTitle(title);
//				notice.setContent(content);
//				notice.setRegDate(regDate);
//				notice.setHit(hit);
//				notice.setFiles(files);
//				notice.setWriterId(writerId);
//
//				list.add(notice);
//			}
//			
//			rs.close();
//			st.close();
//			con.close(); // 서버닫기!
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();		
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		
//		return list; //4.list를 반환해준다
//	}
//
//	
//	public int getNoticeCount() {
//		return getNoticeCount("title","");
//	}
//	
//	public int getNoticeCount(String field, String query) {
//		return 0;
//	}
//	
//	public Notice getNotice(int id) { //id받아오기 
//		String sql = "SELECT * FROM NOTICE WHERE ID=" + id;
//		return null;
//	}
//	
//	public Notice getNextNotice(int id) { //다음 
//		String sql = "SELECT * FROM NOTICE" +
//				"WHERE ID = ( " +
//				"	SELECT ID FROM NOTICE " +
//				"	WHERE REGDATE > (SELECT REGDATE FROM NOTICE WHERE ID=3)" +
//				"	AND ROWNUM = 1 " +
//				")";
//		return null;
//	}
//	
//	public Notice getPrevNotice(int id) {
//		
//		String sql = "SELECT ID FROM (SELECT * FROM NOTICE ORDER BY REGDATE DESC) " +
//		"WHERE REGDATE < (SELECT REGDATE FROM NOTICE WHERE ID=3) " +
//		"AND ROWNUM = 1";
//		
//		return null;
//	}
//	
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
