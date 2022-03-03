package com.vc.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	private static final String INSERT_QUERY_EMP1="INSERT INTO EMP VALUES(111,'XXX',7000,'Daund',sysdate)";
	private static final String INSERT_QUERY_EMP2="INSERT INTO EMP VALUES(112,'YYY',8000,'Daund',sysdate)";
	private static final String INSERT_QUERY_EMP3="INSERT INTO EMP VALUES(113,'ZZZ',9000,'Daund',sysdate)";
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "Sukantg#007");
			con.setAutoCommit(false);
			st=con.createStatement();			
			st.executeUpdate(INSERT_QUERY_EMP1);
			st.executeUpdate(INSERT_QUERY_EMP2);
			st.executeUpdate(INSERT_QUERY_EMP3);
			con.commit();
			System.out.println("Transaction Completed...");
		}catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}			
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

