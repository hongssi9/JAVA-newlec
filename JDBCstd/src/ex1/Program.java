//package ex1;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Date;
//
//public class Program {
//
//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		//1.fornam
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		//2.connection
//		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
//		Connection con = DriverManager.getConnection(url, "BOOK", "12345");		
//		//3.statement
//		Statement st = con.createStatement();
//		//4.resultset
//		String sql = "SELECT * FROM MEMBER ";
//		ResultSet rs = st.executeQuery(sql);
//		
//		//1.쿼리문 한줄 가져오기
//		while(rs.next()) { //if문은 가져올 데이터가 없으면 오류가 뜰 수 있으니까 데이터가 없어도 실행될 수 있게 하기 위하여
//		//2.어떤 쿼리문 데이형식으로 가져오기
//		String id = rs.getString("ID");
//		String pw = rs.getString("PWD");
//		String name = rs.getString("NAME");
//		String gender = rs.getString("GENDER");
//		String birt = rs.getString("BIRTHDAY");
//		String phone = rs.getString("PHONE");
//		String email = rs.getString("EMAIL");
//		String nickname = rs.getString("NICKNAME");
//		
//		
////		System.out.printf("아이디:%s,비밀번호:%s,이름:%s,성별:%s,생년월일:%s,핸드폰:%s,이메일%s,별명%s \n",id,pw,name,gender,birt,phone,email,nickname);
//		}
//		//3.가져온 쿼리문을 출력하기
////		if(rs.next()) { //쿼리문 한줄 가져오기
////		String title = rs.getString("TITLE");
////		System.out.println(title);
////		}
//		
//		rs.close();
//		st.close();
//		con.close();
//	}
//
//}
