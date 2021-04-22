package com.newlecture.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCProgram2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM MEMBER";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111");
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		rs.next();
		System.out.printf("nicname : %s\n", rs.getString("NICNAME"));
		
		rs.next();
		System.out.printf("nicname : %s\n", rs.getString("NICNAME"));
	}

}
