package com.vc.resultsettype;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
			st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=st.executeQuery(SELECT_QUERY_EMP);
			if(rs!=null) {
				System.out.println("Forward Direction---->");
				System.out.println("EID\tENAME\tESAL\tEADDR");
				while(rs.next()) {
					System.out.print(rs.getInt("eid")+"\t");
					System.out.print(rs.getString("ename")+"\t");
					System.out.print(rs.getFloat("esal")+"\t");
					System.out.print(rs.getString("eaddr")+"\n");					
				}
				System.out.println("<-----Backword Direction");
				System.out.println("EID\tENAME\tESAL\tEADDR");
				while(rs.previous()) {
					System.out.print(rs.getInt("eid")+"\t");
					System.out.print(rs.getString("ename")+"\t");
					System.out.print(rs.getFloat("esal")+"\t");
					System.out.print(rs.getString("eaddr")+"\n");
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
