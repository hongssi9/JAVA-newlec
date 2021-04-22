package com.newlecture.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCProgram {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		nicname : newlec
//		----------[ 검색된 데이터 ]--------------
//		id:1, nicname:newlec,..........
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM MEMBER"; //WHERE ID=1조건문을 쿼리문으로 주면 조건문 사용할 필요가 없음

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111");

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		
		// 멤버 데이터
//		int id =rs.getInt("id");
//		String nicName = rs.getString("nicname");
//		String pwd = rs.getString("pwd");

		while (rs.next()) {
//		if(rs.getInt("ID") > 30) {
//		rs.next();
			System.out.printf("id:%d, nicname:%s, pwd:%s\n", rs.getInt("ID"), rs.getString("NICNAME"),rs.getString("PWD"));
		}
	}
	

}
