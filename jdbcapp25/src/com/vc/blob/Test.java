package com.vc.blob;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {

	private static final String SELECT_QUERY_PERSON="SELECT * FROM PERSON";
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "Sukantg#007");
			ps=con.prepareStatement(SELECT_QUERY_PERSON);
			rs=ps.executeQuery();
			FileOutputStream fos=new FileOutputStream("D:\\Student\\img\\db_img\\img10.jpg");
			if(rs.next()) {
				String name=rs.getString("pname");
				InputStream is=rs.getBlob("photo").getBinaryStream();
				byte[] b=new byte[1024];
				while(is.read(b)>0) {
					fos.write(b);
				}
				fos.flush();
			}
			System.out.println("Successfully write the image");
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
