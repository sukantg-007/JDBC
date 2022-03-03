package com.vc.readblob;

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
		FileOutputStream fos=null;
		int i=0;
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "Sukantg#007");
			ps=con.prepareStatement(SELECT_QUERY_PERSON);
			rs=ps.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					i++;
					String name=rs.getString(1);
					InputStream is=rs.getBinaryStream(2);
					byte[] b=new byte[1024];
					fos=new FileOutputStream("D:\\Student\\img\\db_img\\"+name+i+".jpg");
					while(is.read(b)>0) {
						fos.write(b);
					}					
				}
			}
			System.out.println("Data Available at : D:\\Student\\img\\db_img");
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
