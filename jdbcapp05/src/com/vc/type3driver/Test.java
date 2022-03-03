package com.vc.type3driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	private final static String SELECT_QUERY_STUDENT="SELECT * FROM STUDENT"; 
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			Class.forName("ids.sql.IDSDriver");
			con=DriverManager.getConnection("jdbc:ids://localhost:12/conn?dsn=studentdsn");
			st=con.createStatement();
			rs=st.executeQuery(SELECT_QUERY_STUDENT);
			if(rs!=null) {
				while(rs.next()) {
					System.out.println("Student Information :");
					System.out.println("Student Id : "+rs.getInt("sno"));
					System.out.println("Student Name : "+rs.getString("sname"));									
					System.out.println("Student Addr : "+rs.getString("saddr"));
					System.out.println("Student per	: "+rs.getInt("avg") );
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
