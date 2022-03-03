package com.vc.clobread;

import java.io.FileWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {

	private static final String SELECT_QUERY_RESUME="SELECT * FROM RESUME";
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;		
		try {
			FileWriter fw=new FileWriter("D:\\Adv Python\\from_db\\abc.pdf");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "Sukantg#007");
			ps=con.prepareStatement(SELECT_QUERY_RESUME);
			rs=ps.executeQuery();
			if(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(3);
				Reader r=rs.getCharacterStream(2);
				
				char[] c=new char[1024];
				while(r.read(c)>0) {
					fw.write(c);
				}
				fw.flush();
				System.out.println("File id : "+id);
				System.out.println("File Name : "+name);
			}
			System.out.println("Successfully write data...check file");
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
