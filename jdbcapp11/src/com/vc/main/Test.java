package com.vc.main;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {

	private static final String SELECT_STUDENT_QUERY="SELECT * FROM STUDENT2";
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		FileOutputStream fos=null;
		String data="";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Sukantg#007");
			st=con.createStatement();
			rs=st.executeQuery(SELECT_STUDENT_QUERY);
			data=data+"<html><body>";
			data=data+"<table align=\"center\" border=\"1\">";
			data=data+"<tr><th>SID</th><th>SNAME</th><th>SADDR</th><th>SMOBILE</th></tr>";
			while(rs.next()) {
				data=data+"<tr><td>"+rs.getInt("sid")+"</td>"+ 
						" <td>"+rs.getString("sname")+"</td>"+
						" <td>"+rs.getString("saddr")+"</td>"+
						" <td>"+rs.getString("smobile")+"</td>"+
						"  </tr>";
			}
			data=data+"</table></body></html>";
			fos=new FileOutputStream("student.html");			
			byte[] b=data.getBytes();
			fos.write(b);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fos.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
