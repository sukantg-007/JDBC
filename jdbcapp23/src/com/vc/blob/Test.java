package com.vc.blob;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test {

	private static final String INSERT_QUERY_PERSON="INSERT INTO PERSON VALUES (?,?)";
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "Sukantg#007");
			File f=new File("D:/Student/img/img1.jpg");
			FileInputStream fis=new FileInputStream(f);
			ps=con.prepareStatement(INSERT_QUERY_PERSON);
			ps.setString(1,"Aishwarya");
			ps.setBinaryStream(2, fis);
			int count=ps.executeUpdate();
			if(count>0) {
				System.out.println("Record Inserted Successfully");
			}else {
				System.out.println("Record Not inserted...");
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
