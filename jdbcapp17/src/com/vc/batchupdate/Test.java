package com.vc.batchupdate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.util.Scanner;

public class Test {

	private static final String UPDATE_QUERY_EMP="UPDATE EMP SET EDOJ=? WHERE EID=?";
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "Sukantg#007");
			ps=con.prepareStatement(UPDATE_QUERY_EMP);
			//Date d1=new Date();
			//Date d1=new Date("15-aug-21");
			//Date d1=java.sql.Date.valueOf("2021-08-12");
			
			long val=java.sql.Date.parse("10-aug-21");
			
			System.out.println(val);
			java.sql.Date doj=new java.sql.Date(val);
			ps.setDate(1, doj);
			int choice;
			do {
			System.out.println("Enter Employee Id : ");
			int id=sc.nextInt();
			ps.setInt(2, id);			
			ps.addBatch();
			System.out.println("Your want to continue [yes-1|no-0]: ");
			choice=sc.nextInt();
			}while(choice!=0);
			int status[]= ps.executeBatch();
			for(int s: status) {
				System.out.println("Record Status [1-Updated|0-Failed]: "+s);
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
