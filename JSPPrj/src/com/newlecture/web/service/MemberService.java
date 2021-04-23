package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.newlecture.web.entity.Member;

public class MemberService {
	public Member[] getList() throws ClassNotFoundException, SQLException {
		Member[] list = new Member[21];
		int i = 0;

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
//		String sql = String.format("SELECT * FROM MEMBER WHERE NICNAME='%s'",name); //문자열을 값으로 인식하는 방법?
		String sql = "SELECT * FROM MEMBER";

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111");

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql); // 서버에 있는걸 가져오는..공간
//		rs.get..공간에서 데이터를 꺼내온다

		while (rs.next()) {
			int id = rs.getInt("id");
			String nicName = rs.getString("nicname");
			String pwd = rs.getString("pwd");
//			System.out.printf("id:%d, nicname:%s, pwd:%s\n", id, nicName, pwd);
//			list[i] = new Member(id, nicName, pwd);  생성자로 만드는방법
			Member member = new Member();
			member.setId(id);
			member.setNicName(nicName);
			member.setPwd(pwd);

			list[i++] = member;
		}
		return list;
	}
}
