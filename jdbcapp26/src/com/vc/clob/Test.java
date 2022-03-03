package com.vc.clob;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test {

	private static final String INSERT_QUERY_RESUME="INSERT INTO RESUME VALUES (?,?, ?)";
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system", "Sukantg#007");
			ps=con.prepareStatement(INSERT_QUERY_RESUME);
			ps.setInt(1,1);
			ps.setString(3, "MatplotLib");
			FileReader fr=new FileReader("D:\\Adv Python\\matplotlib.pdf");			
			ps.setClob(2,fr);			
			int count=ps.executeUpdate();
			if(count>0) {
				System.out.println("Successfully Inserted Resume..");
			}else {
				System.out.println("Not Inserted Data..");
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
