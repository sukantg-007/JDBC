package com.vc.type4driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test5 {

	private static final String SELECT_QUERY_EMP="SELECT * FROM EMP";
	private static final String INSERT_QUERY_EMP="INSERT INTO EMP VALUES (104,'EEE',9000,'Nashik')";
	public static void main(String[] args) {
		Connection con=null;
		Statement st= null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Sukantg#007");
			st=con.createStatement();
			boolean b=st.execute(INSERT_QUERY_EMP);
			System.out.println("Select Query : "+b);
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

	}

}
