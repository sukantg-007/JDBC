package com.vc.blob;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Test {

	private static final String INSERT_QUERY_PERSON="INSERT INTO PERSON VALUES (?,?)";
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "Sukantg#007");
			ps=con.prepareStatement(INSERT_QUERY_PERSON);
			ps.setString(1,"Aishwarya");
			File f=new File("D:\\Student\\img\\img1.jpg");
			FileInputStream fis=new FileInputStream(f);			
			//ps.setBinaryStream(2, fis);
			ps.setBlob(2, fis);						
			int count=ps.executeUpdate();
			if (count>0) {
				System.out.println("Recored Inserted Successfully...");
			}else {
				System.out.println("Recored Not inserted ...");
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
