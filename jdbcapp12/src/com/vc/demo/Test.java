package com.vc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Sukantg#007");
			st=con.createStatement();
			String query="";
			while(true) {
				System.out.println("Query : ");
				query=sc.nextLine();
				if(query.equalsIgnoreCase("exit"))
					break;
				boolean b;
				try {
					b=st.execute(query);
				} catch (SQLException e) {
					b=false;
					System.out.println(e.getMessage());
				}				
				
				if(b==true) {
					//select query
					rs=st.getResultSet();
					if(rs!=null) {
						ResultSetMetaData rmeta=rs.getMetaData();
						int count=rmeta.getColumnCount();
						for (int i = 1; i <= count; i++) {
							System.out.print(rmeta.getColumnName(i)+"\t");
						}
						System.out.println();
						while(rs.next()) {
							for (int i = 1; i <= count; i++) {
								System.out.print(rs.getString(i)+"\t");
							}
							System.out.println();
						}
					}
					else {
						System.out.println("Table is not available");
					}
				}else {
					//not select query
					int count=st.getUpdateCount();
					if(count>0) {
						System.out.println("Successfully Updated/Deleted/Inserted.."+count);
					}
					else
					{	
						System.out.println("Failed to Updated/Deleted/Inserted..");
					}
				}
			}
			System.out.println("Good bye...");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
