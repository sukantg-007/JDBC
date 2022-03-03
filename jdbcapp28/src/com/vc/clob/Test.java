package com.vc.clob;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test {

	private static final String INSERT_QUERY_HISTORY="INSERT INTO HISTORY VALUES (?,?)";
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "Sukantg#007");
			ps=con.prepareStatement(INSERT_QUERY_HISTORY);
			ps.setString(1, "Exam Form");
			FileReader fr=new FileReader("D:\\Student\\Text file\\134400494_ExamForm.PDF");
			ps.setCharacterStream(2, fr);
			int count=ps.executeUpdate();
			if(count>0) {
				System.out.println("Record Inserted");
			}else {
				System.out.println("Record Not Inserted");
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
