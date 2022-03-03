package com.vc.type4driveradv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test2 {

	private static final String UPDATE_QUERY_EMP="UPDATE EMP SET ESAL=ESAL+1000 WHERE ENAME='GGG'";
	private static final String DELETE_QUERY_EMP="DELETE FROM EMP WHERE ENAME='GGG'";
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Sukantg#007");
			st=con.createStatement();
//			int count=st.executeUpdate(UPDATE_QUERY_EMP);
//			System.out.println("Record Updated : "+count);
			
			int count=st.executeUpdate(DELETE_QUERY_EMP);
			System.out.println("Record Deleted : "+count);
			
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
