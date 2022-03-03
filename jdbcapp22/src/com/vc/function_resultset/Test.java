package com.vc.function_resultset;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;

import oracle.jdbc.OracleTypes;

public class Test {

	public static void main(String[] args) {
		Connection con=null;
		CallableStatement cst=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "Sukantg#007");
			cst=con.prepareCall("{?= call getemp(?,?)}");			
			cst.setInt(2, 102);
			cst.setInt(3, 107);
			cst.registerOutParameter(1, OracleTypes.CURSOR);
			cst.execute();
			rs=(ResultSet) cst.getObject(1);
			if(rs!=null) {
				System.out.println("EID\tENAME\tESAL\tEADDR\tEDOJ");
				while(rs.next()) {
					System.out.print(rs.getInt(1)+"\t");
					System.out.print(rs.getString(2)+"\t");
					System.out.print(rs.getFloat(3)+"\t");
					System.out.print(rs.getString(4)+"\t");
					System.out.print(rs.getDate(5)+"\n");
				}
			}
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
