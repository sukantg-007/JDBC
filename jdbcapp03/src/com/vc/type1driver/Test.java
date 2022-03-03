package com.vc.type1driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	
	private static final String CREATE_TABLE_EMP_QUERY="CREATE TABLE EMP(EID NUMBER(3) PRIMARY KEY,"
																		+ "ENAME VARCHAR2(15),"
																		+ "ESAL NUMBER(11,2),"
																		+ "EADDR VARCHAR2(15))";
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:oracledsn","system","Sukantg#007");
			st=con.createStatement();
			int count=st.executeUpdate(CREATE_TABLE_EMP_QUERY);
			if(count==1)
				System.out.println("Table created Successfully");
			else
				System.out.println("Table not created..try again");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}

