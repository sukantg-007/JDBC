package com.vc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test {

	private static final String INSERT_QUERY_EMP="INSERT INTO EMP VALUES (?,?,?,?)";
	private static final String UPDATE_QUERY_EMP="UPDATE EMP SET ENAME=?, EADDR=? WHERE EID=?";
	private static final String DELETE_QUERY_EMP="DELETE FROM EMP WHERE ENAME=?";
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Sukantg#007");
			//ps=con.prepareStatement(INSERT_QUERY_EMP);
			//ps=con.prepareStatement(UPDATE_QUERY_EMP);
			ps=con.prepareStatement(DELETE_QUERY_EMP);
			//ps.setInt(3,102);
			ps.setString(1,"BBB");			
			//ps.setString(2,"Kashti");
			int count=ps.executeUpdate();
			//String msg=count>0?"Record Inserted Successfully":"Updation Failed...";
			//String msg=count>0?"Record Updated Successfully":"Updation Failed...";
			String msg=count>0?"Record Deleted Successfully":"Deletion Failed...";
			System.out.println(msg);
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
