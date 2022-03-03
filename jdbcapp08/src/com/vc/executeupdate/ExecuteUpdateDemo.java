package com.vc.executeupdate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExecuteUpdateDemo {

	private static final String UPDATE_QUERY_EMP="UPDATE EMP SET ESAL=ESAL+1000 WHERE EID>=102";
	private static final String DELETE_QUERY_EMP="DELETE FROM EMP WHERE EID>=103";
	public static void main(String[] args) {	
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Sukantg#007");
			st=con.createStatement();
			//rs=st.executeQuery(UPDATE_QUERY_EMP);
			rs=st.executeQuery(DELETE_QUERY_EMP);
			int count=st.getUpdateCount();
			//System.out.println("Record Updated : "+count);
			System.out.println("Record Deleted : "+count);
		} catch (Exception e) {
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
