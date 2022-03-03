package com.vc.type4driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test3 {

	private static final String UPDATE_QUERY_STUDENT="UPDATE STUDENT SET SNAME='GGG' WHERE SNO=102";
	public static void main(String[] args) {	
		Connection con=null;
		Statement st=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Sukantg#007");
			st=con.createStatement();
			int count=st.executeUpdate(UPDATE_QUERY_STUDENT);
			if(count>0) {
				System.out.println("Successfully updated");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				st.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

}
