package com.vc.type2driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	private static final String QUERY_SELECT_STUDENT="SELECT * FROM STUDENT2";
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//con=DriverManager.getConnection("jdbc:oracl:oci8@orcl","system","Sukantg#007");
			//con=DriverManager.getConnection("jdbc:oracle:oci:@localhost:1521:orcl","system","Sukantg#007");
			con=DriverManager.getConnection("jdbc:oracle:oci:@localhost:1521:orcl","system","Sukantg#007");
			st=con.createStatement();
			rs=st.executeQuery(QUERY_SELECT_STUDENT);
			if(rs!=null) {
				System.out.println("Student Infromation");
				while(rs.next()) {
					System.out.println("-------------------------------------");
					System.out.println("Student Name : "+rs.getString("uname"));
					System.out.println("Student Id : "+rs.getString("upass"));
					System.out.println("-------------------------------------");
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

	}

}
