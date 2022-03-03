package com.vc.procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import com.sun.xml.internal.ws.org.objectweb.asm.Type;

public class Test {

	public static void main(String[] args) {
		Connection con=null;
		CallableStatement cs=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "Sukantg#007");
			cs=con.prepareCall("{call proadd(?,?,?)}");
			cs.setInt(1, 100);
			cs.setInt(2, 200);
			cs.registerOutParameter(3, Type.INT);
			cs.execute();
			System.out.println("Addition is : "+cs.getInt(3));
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
