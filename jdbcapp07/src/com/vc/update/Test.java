package com.vc.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test {

	private static final String UPDATE_QUERY_EMP="UPDATE EMP SET ESAL=ESAL+1000 WHERE EID>=102";
	private static final String DELETE_QUERY_EMP="DELETE FROM EMP WHERE EID>=103";
	private static final String INSERT_QUERY_EMP="INSERT INTO EMP VALUES(104,'DDD',9000,'PUNE')";
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Sukantg#007");
			st=con.createStatement();
			//boolean b=st.execute(UPDATE_QUERY_EMP);
			//boolean b=st.execute(DELETE_QUERY_EMP);
			boolean b=st.execute(INSERT_QUERY_EMP);
			System.out.println(b);
			
			int count=st.getUpdateCount();
			System.out.println("Record Updated : "+count);
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
