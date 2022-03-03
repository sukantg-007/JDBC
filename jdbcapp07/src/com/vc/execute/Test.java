package com.vc.execute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {

	private static final String SELECT_QUERY_EMP="SELECT * FROM EMP";
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Sukantg#007");
			st=con.createStatement();
			boolean b=st.execute(SELECT_QUERY_EMP);
			if(b==true)
				rs=st.getResultSet();
			System.out.println("Eid\tEname\tEsal\tEaddr");
			if(rs!=null) {
				while(rs.next())
				{
					System.out.println(rs.getInt("eid")+"\t"+rs.getString("ename")+"\t"+rs.getFloat("esal")+"\t"+rs.getString("eaddr"));
				}
				
			}
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
