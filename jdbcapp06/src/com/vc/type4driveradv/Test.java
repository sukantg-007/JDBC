package com.vc.type4driveradv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	private static final String INSERT_QUERY_EMP="INSERT INTO EMP VALUES (105,'FFF',4000,'Daund')";
	private static final String INSERT_QUERY2_EMP="INSERT INTO EMP VALUES (106,'GGG',5000,'Daund')";
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		int count=0;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Sukantg#007");
			st=con.createStatement();
			count=count+st.executeUpdate(INSERT_QUERY_EMP);
			count=count+st.executeUpdate(INSERT_QUERY2_EMP);
			System.out.println("Record Updated : "+count);
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
