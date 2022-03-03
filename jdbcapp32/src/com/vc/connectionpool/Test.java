package com.vc.connectionpool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.dbcp2.BasicDataSource;

public class Test {

	private static final String SELECT_QUERY_CUSTOMER="SELECT * FROM CUSTOMER";
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			BasicDataSource ds=new BasicDataSource();
			ds.setDriverClassName("oracle.jdbc.OracleDriver");
			ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
			ds.setUsername("system");
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
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
