package com.vc.transaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {

	private static final String UPDATE_QUERY_ACCOUNT_DEBIT="UPDATE ACCOUNT SET BALANCE=BALANCE - ? WHERE ACCNO=?";
	private static final String UPDATE_QUERY_ACCOUNT_CREDIT="UPDATE ACCOUNT SET BALANCE=BALANCE + ? WHERE ACCNO=?";
	
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		BufferedReader br=null;
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "Sukantg#007");
			con.setAutoCommit(false);
			br=new BufferedReader(new InputStreamReader(System.in));			
			ps=con.prepareStatement(UPDATE_QUERY_ACCOUNT_DEBIT);	
			System.out.print("Enter account number : ");String faccno=br.readLine();
			System.out.print("Withdrawal Amount : ");int withAmt=Integer.parseInt(br.readLine());
			ps.setInt(1, withAmt);
			ps.setString(2, faccno);
			int c1=ps.executeUpdate();
			ps=con.prepareStatement(UPDATE_QUERY_ACCOUNT_CREDIT);
			System.out.print("Enter account number : ");faccno=br.readLine();
			ps.setInt(1, withAmt);
			ps.setString(2, faccno);
			int c2=ps.executeUpdate();
			if(c1>0&&c2>0) {
				System.out.println("Transaction Successfull..");
				con.commit();
			}
			else {
				System.out.println("Transaction Failed..");
				con.rollback();
			}
			System.out.println("Transaction Completed...");
		}catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}			
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}	finally {
		
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
