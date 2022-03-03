package com.vc.connectionpooling;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import oracle.jdbc.pool.OracleDataSource;



public class Test {

	private static final String SELECT_QUERY_CUSTOMER="SELECT * FROM CUSTOMER";
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			OracleDataSource ds=new OracleDataSource();
			ds.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
			ds.setUser("system");
			ds.setPassword("Sukantg#007");
			con=ds.getConnection();
			ps=con.prepareStatement(SELECT_QUERY_CUSTOMER);
			rs=ps.executeQuery();
			if(rs!=null) {
				System.out.println("CID\tCNAME\tCADDR\tMOBILE");
				while(rs.next()) {
					System.out.print(rs.getInt(1)+"\t");
					System.out.print(rs.getString(2)+"\t");
					System.out.print(rs.getString(3)+"\t");
					System.out.print(rs.getString(4)+"\n");
				}
			}
			
		} catch (Exception e) {
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
