package com.vc.resultsettype;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test2 {
	private static final String SELECT_QUERY_EMP="SELECT * FROM EMP";
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
		Class.forName("oracle.jdbc.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Sukantg#007");
		st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs=st.executeQuery(SELECT_QUERY_EMP);
		rs.first();
		System.out.println(rs.getInt("eid"));
		rs.last();
		System.out.println(rs.getInt("eid"));
		rs.beforeFirst();
		rs.next();
		System.out.println(rs.getInt("eid"));
		rs.afterLast();
		rs.previous();
		System.out.println(rs.getInt("eid"));
		rs.absolute(-3);
		System.out.println(rs.getInt("eid"));
		rs.absolute(3);
		System.out.println(rs.getInt("eid"));
		rs.relative(-2);
		System.out.println(rs.getInt("eid"));
		rs.relative(1);
		System.out.println(rs.getInt("eid"));
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
