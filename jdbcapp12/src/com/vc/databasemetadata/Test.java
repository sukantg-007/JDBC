package com.vc.databasemetadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;


public class Test {

	public static void main(String[] args) {
		Connection con=null;		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Sukantg#007");
			DatabaseMetaData meta=con.getMetaData();
			System.out.println("Database Name : "+meta.getDatabaseProductName());
			System.out.println("Database Vers : "+meta.getDatabaseProductVersion());
			System.out.println("Db Major Vers : "+meta.getDatabaseMajorVersion());
			System.out.println("Db Minor vers : "+meta.getDatabaseMinorVersion());
			System.out.println("SQL Keywords : "+meta.getSQLKeywords());
			System.out.println("SQL String fun: "+meta.getStringFunctions());
			System.out.println("SQL Number Fun : "+meta.getNumericFunctions());
			System.out.println("Batch Update Supp : "+meta.supportsBatchUpdates());
			System.out.println("Stored Proc Supp : "+meta.supportsStoredProcedures());
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
