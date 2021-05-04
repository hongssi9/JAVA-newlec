package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.fornam
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2.connection
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		Connection con = DriverManager.getConnection(url, "newlec", "11111");		
		//3.statement
		Statement st = con.createStatement();
		//4.resultset
		String sql = "SELECT * FROM NOTICE";
		ResultSet rs = st.executeQuery(sql);
		
		//1.쿼리문 한줄 가져오기
		rs.next();
		//2.어떤 쿼리문 데이형식으로 가져오기
		String title = rs.getString("TITLE");
		System.out.println(title);
		//3.가져온 쿼리문을 출력하기
//		if(rs.next()) { //쿼리문 한줄 가져오기
//		String title = rs.getString("TITLE");
//		System.out.println(title);
//		}
		
		rs.close();
		st.close();
		con.close();
	}

}
