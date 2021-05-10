package project.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project.entity.Member;

public class MemberService {
	public List<Member> getList() throws ClassNotFoundException, SQLException {
		List<Member> list = new ArrayList<>();

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM USER_";
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "book", "12345");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			String id = rs.getString("id");
			String pwd = rs.getString("pwd");
			String name = rs.getString("name");
			String gender = rs.getString("gender");
			String birthday = rs.getString("birthday");
			String phone = rs.getString("phone");
			String email = rs.getString("email");
			
			Member member = new Member();
			member.setId(id);
			member.setPwd(pwd);
			member.setName(name);
			member.setGender(gender);
			member.setBirthday(birthday);
			member.setPhone(phone);
			member.setEmail(email);
			
			list.add(member);
			//System.out.printf("아이디:%s,비밀번호:%s,이름:%s,성별:%s,생년월일:%s,핸드폰:%s,이메일%s\n",id,pwd,name,gender,birthday,phone,email);
		}
		
		return list;

	}
}
