package com.vc.clobread;

import java.io.FileWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {
		private static final String SELECT_QUERY_RESUME="SELECT * FROM HISTORY";
		public static void main(String[] args) {
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs=null;	
			FileWriter fw=null;
			try {
				
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "Sukantg#007");
				ps=con.prepareStatement(SELECT_QUERY_RESUME);
				rs=ps.executeQuery();
				while(rs.next()) {
					String name=rs.getString(1);
					fw=new FileWriter("D:\\Student\\Text file\\db_file\\"+name+".pdf");
					Reader r=rs.getCharacterStream(2);					
					char[] c=new char[1024];
					while(r.read(c)>0) {
						fw.write(c);
					}
					fw.flush();					
					System.out.println("Created ...File Name : "+name);
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
