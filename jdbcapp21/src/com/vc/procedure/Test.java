package com.vc.procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import oracle.jdbc.OracleTypes;

public class Test {

	public static void main(String[] args) {
		Connection con=null;
		CallableStatement cst=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "Sukantg#007");
			cst=con.prepareCall("{call getallemp(?)}");
			cst.registerOutParameter(1, OracleTypes.CURSOR);
			cst.execute();
			rs=(ResultSet) cst.getObject(1);
			if(rs!=null) {
				ResultSetMetaData meta=rs.getMetaData();
				int count=meta.getColumnCount();
				for (int i = 1; i <=count; i++) {
					System.out.print(meta.getColumnName(i)+"\t");
				}
				System.out.println();
				while(rs.next()) {
					for (int i = 1; i <=count; i++) {
						System.out.print(rs.getString(i)+"\t");
					}
					System.out.println();
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
