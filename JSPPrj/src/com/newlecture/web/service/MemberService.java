package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.entity.Member;


//가변형 배열인 getlist()를 만들어줬다 List<> -> http객체 인스턴스 member
public class MemberService {
	public List<Member> getList() throws ClassNotFoundException, SQLException { 
		List<Member> list = new ArrayList<>(); 
//		int i = 0;

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
//		String sql = String.format("SELECT * FROM MEMBER WHERE NICNAME='%s'",name); //문자열을 값으로 인식하는 방법?
		String sql = "SELECT * FROM MEMBER";

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111");

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql); // 서버에 있는걸 가져오는..공간
//		rs.get..공간에서 데이터를 꺼내온다
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

			list.add(member);
		}
		return list;
		
		
	}
	
	   public Member getByNicName(String userName) {
		      
		      Member member = null;
		      
		      String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		      //String sql = "SELECT * FROM MEMBER WHERE NICNAME=" + "'" + nickname +"'";
		      //String sql = String.format("SELECT * FROM MEMBER WHERE NICNAME='%s'", nickname);
		      String sql = "SELECT * FROM MEMBER WHERE NICNAME=?";
		      
		      try {
		         Class.forName("oracle.jdbc.OracleDriver");
		         Connection con = DriverManager.getConnection(url, "NEWLEC", "11111");
		         
		         PreparedStatement st = con.prepareStatement(sql);
		         st.setString(1, userName);
		         
		         ResultSet rs = st.executeQuery();
		         
		         // 읽어온 레코드가 없을 때까지 반복하시오.
		         // 다 하셨으면 손!!!!
		         
		         // 멤버 데이터   
		         if(rs.next()) {
		            int id = rs.getInt("id");
		            String nicName = rs.getString("nicname");
		            String pwd = rs.getString("pwd");
		            
		            //System.out.printf("id:%d, nicname:%s, pwd:%s\n", id, nicName, pwd);
		            member = new Member();
		            member.setId(id);
		            member.setNicName(nicName);
		            member.setPwd(pwd);                        
		         }
		         
		         rs.close();
		         st.close();
		         con.close();
		      } catch (ClassNotFoundException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		      } catch (SQLException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		      }
		      
		      
		      
		      return member;
		   }
		


	public static Member get(String userName) {
		// TODO Auto-generated method stub
		return null;
	}
}
