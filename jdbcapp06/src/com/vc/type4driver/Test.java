package com.vc.type4driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	private static final String SELECT_QUERY_STUDENT="SELECT * FROM STUDENT";	
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Sukantg#007");
			st=con.createStatement();
			rs=st.executeQuery(SELECT_QUERY_STUDENT);
			if(rs != null) {
				while (rs.next()) {
					System.out.println("Student Information :");
					System.out.println("Student Name : "+rs.getString("sname"));
					System.out.println("Student No : "+rs.getInt("sno"));
					System.out.println("-------------------------------");
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				st.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}			
		}

	}

}
