package com.vc.executeupdate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExecuteUpdate {

	private static final String SELECT_QUERY_EMP="SELECT * FROM EMP";
	public static void main(String[] args) {		
			Connection con=null;
			Statement st=null;
			ResultSet rs=null;
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Sukantg#007");
				st=con.createStatement();
				//rs=st.executeQuery(UPDATE_QUERY_EMP);
				int count=st.executeUpdate(SELECT_QUERY_EMP);				
				//System.out.println("Record Updated : "+count);
				System.out.println("Records  : "+count);
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

