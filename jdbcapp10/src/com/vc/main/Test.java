package com.vc.main;

import java.util.Scanner;

import com.vc.bean.Student;
import com.vc.factory.StudentServiceFactory;
import com.vc.service.IStudentService;

public class Test {

	public static void main(String[] args) {
		int choice;
		Scanner sc=new Scanner(System.in);
		Student std;
		IStudentService studentService;
		int sid;
		String sname, saddr, smobile, msg="";
		do
		{
			System.out.println("----MENU----");
			System.out.println("1. Add Student");
			System.out.println("2. Delete Student");
			System.out.println("3. Search Student");
			System.out.println("4. Update Student");
			System.out.println("5. Exit");
			System.out.print("Enter Your Choice : ");
			choice=sc.nextInt();
			
			switch (choice) {
			case 1:	System.out.println("Enter Student Information");
					System.out.print("Student Id : ");sid=sc.nextInt();sc.nextLine();
					System.out.print("Student Name : ");sname=sc.nextLine();
					System.out.print("Student Addr : ");saddr=sc.nextLine();
					System.out.print("Student Mobile : ");smobile=sc.nextLine();
					std=new Student();
					std.setSid(sid);
					std.setSname(sname);
					std.setSaddr(saddr);
					std.setSmobile(smobile);
					studentService=StudentServiceFactory.getStudentService();
					msg =studentService.addStudent(std);
					System.out.println("Status : "+msg);
				break;
			case 2:	System.out.println("Enter Student Information");
					System.out.print("Student Id : ");sid=sc.nextInt();
					studentService=StudentServiceFactory.getStudentService();
					msg =studentService.deleteStudent(sid);
					System.out.println("Status : "+msg);
				break;
			case 3:	System.out.println("Enter Student Information");
					System.out.print("Student Id : ");sid=sc.nextInt();
					studentService=StudentServiceFactory.getStudentService();
					std =studentService.searchStudent(sid);
					System.out.println(std);			
				break;
			case 4:	System.out.println("Enter Student Information");
					System.out.print("Student Id : ");sid=sc.nextInt();sc.nextLine();
					System.out.print("Student Name : ");sname=sc.nextLine();
					System.out.print("Student Addr : ");saddr=sc.nextLine();
					System.out.print("Student Mobile : ");smobile=sc.nextLine();
					std=new Student();
					std.setSid(sid);
					std.setSname(sname);
					std.setSaddr(saddr);
					std.setSmobile(smobile);
					studentService=StudentServiceFactory.getStudentService();
					msg =studentService.updateStudent(std);
					System.out.println("Status : "+msg);
				break;
			case 5:System.out.println("Good Bye......");
				break;
			default:System.out.println("Wrong choice...[1,2,3,4,5]");
				break;
			}
		}while(choice!=5);
		sc.close();
	}

}
