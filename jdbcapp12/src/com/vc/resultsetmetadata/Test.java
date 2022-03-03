package com.vc.resultsetmetadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Test {

	private static final String SELECT_QUERY_EMP="SELECT * FROM EMP";
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Sukantg#007");
			st=con.createStatement();
			rs=st.executeQuery(SELECT_QUERY_EMP);
			ResultSetMetaData rmeta=rs.getMetaData();
			int count=rmeta.getColumnCount();
			System.out.println("Number of Column : "+count);
			for (int i = 1; i <= count; i++) {
				System.out.println(i+". Column Name : "+rmeta.getColumnName(i)+"\tColumn Size : "+rmeta.getColumnDisplaySize(i)+"\tData Type : "+rmeta.getColumnTypeName(i));				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
