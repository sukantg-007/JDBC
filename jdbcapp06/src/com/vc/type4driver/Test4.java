package com.vc.type4driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test4 {

	private static final String DELETE_QUERY_STUDENT="DELETE FROM STUDENT WHERE SNO=101";
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Sukantg#007");
			st=con.createStatement();
			int count=st.executeUpdate(DELETE_QUERY_STUDENT);
			if (count>0) {
				System.out.println("Deleted Successfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
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
