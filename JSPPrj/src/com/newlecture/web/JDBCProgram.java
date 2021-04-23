package com.newlecture.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.newlecture.web.entity.Member;
import com.newlecture.web.service.MemberService;

public class JDBCProgram {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("입력창");
		String name = sc.nextLine();
		
		MemberService memberService = new MemberService();
		Member[] list = memberService.getList();
		
		
		
//		nicname : newlec
//		----------[ 검색된 데이터 ]--------------
//		id:1, nicname:newlec,..........

//		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
//		//String sql = "SELECT * FROM MEMBER WHERE NICNAME='" + name + "'"; // WHERE ID=1조건문을 쿼리문으로 주면 조건문 사용할 필요가 없음
//		String sql = String.format("SELECT * FROM MEMBER WHERE NICNAME='%s'",name); //문자열을 값으로 인식하는 방법?
//		
//		Class.forName("oracle.jdbc.OracleDriver");
//		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111");
//
//		Statement st = con.createStatement();
//		ResultSet rs = st.executeQuery(sql); //서버에 있는걸 가져오는..공간
////		rs.get..공간에서 데이터를 꺼내온다
//
//		// 멤버 데이터
//
//		while (rs.next()) {
//			int id = rs.getInt("id");
//			String nicName = rs.getString("nicname");
//			String pwd = rs.getString("pwd");
//			System.out.printf("id:%d, nicname:%s, pwd:%s\n", id, nicName, pwd);
//		}
		
		for(int i=0; i<list.length; i++) {
			Member member = list[i];
			int id = member.getId();
			String nicName = member.getNicName();
			String pwd = member.getPwd();
			System.out.printf("id:%d, nicname:%s, pwd:%s\n",id,nicName,pwd);
		}
	}

}
