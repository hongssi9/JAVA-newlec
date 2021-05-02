package JDBCTEST;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ex1 {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver"); //jdbc객체 껍데기 생성
		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111");  //데이터베이스와 연결
		Statement st = (Statement) con.createStatement(); //sql을 실행하기위한 인터페이스 객체
		ResultSet rs = st.executeQuery(sql); //불러온 데이터를 보여주게하는 반환

	}

}
