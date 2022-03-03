package com.vc.function;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;



public class Test {

	public static void main(String[] args) {
		Connection con=null;
		CallableStatement cst=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "Sukantg#007");
			cst=con.prepareCall("{?= call getavgsal(?,?)}");
			cst.setInt(2, 102);
			cst.setInt(3, 107);
			cst.registerOutParameter(1, Types.FLOAT);
			cst.execute();
			System.out.println("Average Salary is : "+cst.getFloat(1));
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
