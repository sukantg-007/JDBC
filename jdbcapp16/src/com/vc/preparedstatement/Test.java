package com.vc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Test {

	private static final String INSERT_QUERY_EMP="INSERT INTO EMP VALUES (?,?,?,?)";
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Sukantg#007");
			ps=con.prepareStatement(INSERT_QUERY_EMP);
			while(true) {
				System.out.print("Enter Emp Id : ");
				int eid=sc.nextInt();
				System.out.print("Enter Emp Name :");
				sc.nextLine();String ename=sc.nextLine();
				System.out.println("Enter Emp Sal: ");
				float esal=sc.nextFloat();
				System.out.print("Enter Emp Addr :");
				sc.nextLine();String eaddr=sc.nextLine();
				
				ps.setInt(1,eid);
				ps.setString(2, ename);
				ps.setFloat(3, esal);
				ps.setString(4, eaddr);
				int count=ps.executeUpdate();
				System.out.println(count>0?"Record Inserted Successfully":"Insertion Failed..");
				System.out.print("Want to Continue  [y/n]: ");
				String choice=sc.nextLine();
				if(choice.equalsIgnoreCase("n"))
					break;
			}
			System.out.println("Good bye...");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
