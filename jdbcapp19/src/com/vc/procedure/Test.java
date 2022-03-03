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
			cs=con.prepareCall("{call getsalary(?,?)}");
			cs.setInt(1, 105);
			cs.registerOutParameter(2, Type.FLOAT);
			cs.execute();
			System.out.println("Salar of Eid : 100...is "+cs.getFloat(2));
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
