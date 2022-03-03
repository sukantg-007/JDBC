package com.vc.factory;

import com.vc.service.IStudentService;
import com.vc.service.StudentServiceImpl;

public class StudentServiceFactory {
	private static IStudentService studentService;
	static
	{
		studentService=new StudentServiceImpl();
	}

	public static IStudentService getStudentService(){
		return studentService;
	}
}
