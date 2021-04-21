package com.newlecture.web;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;



public class JDBCProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class cls = Class.forName("oracle.jdbc.OracleDriver");
		Method[] methods = cls.getMethod();
		System.out.println(methods[0].getName());
		Connection con = DriverManager.getConnection(null);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(null);
	}

}
