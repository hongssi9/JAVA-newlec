package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.web.entity.Notice;

public class JdbcNoticeService { //서비스 클래스 구현

	public List<Notice> getList() throws ClassNotFoundException, SQLException {
		return getList(1, "title", "");
	}

	public List<Notice> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {
		List<Notice> list = new ArrayList<>();

		// page 1 : startNum : and endNum
		int size = 10;
		int startNum = 1 + (page - 1) * size;
		int endNum = page * size;

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
//		String sql = "SELECT * FROM NOTICE";

		String sql = "SELECT * FROM (" + "    SELECT ROWNUM NUM, N.* " + "    FROM (" + "        SELECT * "
				+ "        FROM NOTICE" + "        WHERE " + field + " LIKE '%" + query + "%'"
				+ "        ORDER BY REGDATE DESC" + "    ) N " + ")" + "WHERE NUM BETWEEN " + startNum + " AND "
				+ endNum + "";

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
		con.close(); // 서버닫기!

		return list;
	}

	public Notice get(int id) throws ClassNotFoundException, SQLException { // 단일값 가져오기(리스트에서 아이디가 각 다른 링크를 누를때 필요한..)
		Notice notice = null;

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE WHERE ID=" + id;
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111");

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql); // 서버에 있는걸 가져오는..공간
		if (rs.next()) {
			String title = rs.getString("title");
			String content = rs.getString("content");
			String writerId = rs.getString("writer_Id");
			Date regDate = rs.getDate("regDate");
			int hit = rs.getInt("hit");
			String files = rs.getString("files");

			notice = new Notice();
			notice.setId(id);
			notice.setTitle(title);
			notice.setContent(content);
			notice.setRegDate(regDate);
			notice.setHit(hit);
			notice.setFiles(files);
			notice.setWriterId(writerId);

		}
		rs.close();
		st.close();
		con.close(); // 서버닫기!
		return notice;
	}

	public int getCount(String field, String query) throws ClassNotFoundException, SQLException {

		int count = 0;

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";

		String sql = "SELECT COUNT(ID) COUNT" + " FROM NOTICE" + " WHERE " + field + " LIKE '%" + query + "%'";

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111");

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql); // 서버에 있는걸 가져오는..공간
		if (rs.next())
			count = rs.getInt("COUNT");

		rs.close();
		st.close();
		con.close(); // 서버닫기!

		return count;

	}

	public int update(Notice notice) throws ClassNotFoundException, SQLException {
		int result = 0;

		String sql = "UPDATE NOTICE SET TITLE=?, CONTENT=?, HIT=?, FILES=? WHERE ID=?"; 
		//실질적으로 타이틀과 컨텐트만 바뀌지만 모든 레코드를 다 업데이트 해줘야하는 문제가 있다.
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111");
		
		
		//데이터 수정하는 방법
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, notice.getTitle()); //sql에서 +연산자로 데이터를 넣는것보다
		st.setString(2, notice.getContent()); 
		st.setInt(3,notice.getHit());
		st.setString(4,notice.getFiles());
		st.setInt(5,notice.getId());
		
		result = st.executeUpdate(); //ex..Query():select, ex..Update(): Update/Delete/Insert 할때 사용
							//주로 두가지
		
		st.close();
		con.close();
		
		return result;
	}

	public int insert(Notice notice) throws ClassNotFoundException, SQLException {
		int result = 0;

		String sql = "INSERT INTO NOTICE(TITLE, WRITER_ID, CONTENT) VALUES(?,?,?)"; 
		//실질적으로 타이틀과 컨텐트만 바뀌지만 모든 레코드를 다 업데이트 해줘야하는 문제가 있다.
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111");
		
		
		//데이터 넣는 방법
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, notice.getTitle()); //sql에서 +연산자로 데이터를 넣는것보다
		st.setString(2, notice.getWriterId()); //이렇게 사용하는게 더 편한 방법
		st.setString(3, notice.getContent());
		
		result = st.executeUpdate(); //ex..Query():select, ex..Update(): Update/Delete/Insert 할때 사용
							//주로 두가지
		
		st.close();
		con.close();
		
		return result;
	}
	
	public int delete(int id) throws ClassNotFoundException, SQLException {
		int result = 0;
					
		String sql = "DELETE FROM NOTICE WHERE ID=?"; //쿼리만 달라지고
		//실질적으로 타이틀과 컨텐트만 바뀌지만 모든 레코드를 다 업데이트 해줘야하는 문제가 있다.
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111");
		
		
		//데이터 넣는 방법 //꽂는거만 바뀜
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1,id); //sql에서 +연산자로 데이터를 넣는것보다
		
		result = st.executeUpdate(); //ex..Query():select, ex..Update(): Update/Delete/Insert 할때 사용
							//주로 두가지
		
		st.close();
		con.close();
		
		return result;
	}
	
	public int hitUp(int id) {
		
		String sql = "UPDATE SET HIT=HIT+1 WHERE ID=?";
		
		return 0;
		
	}



}
