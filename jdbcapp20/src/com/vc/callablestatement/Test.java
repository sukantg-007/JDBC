package com.vc.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import com.sun.xml.internal.ws.org.objectweb.asm.Type;
import com.sun.xml.internal.ws.wsdl.writer.document.Types;

public class Test {

	public static void main(String[] args) {
		Connection con=null;
		CallableStatement cs=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "Sukantg#007");
			cs=con.prepareCall("{call getsal(?)}");
			cs.setInt(1, 106);
			cs.registerOutParameter(1, Type.INT);
			cs.execute();
			int sal=cs.getInt(1);
			System.out.println("Salary of 106 : "+sal);
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
