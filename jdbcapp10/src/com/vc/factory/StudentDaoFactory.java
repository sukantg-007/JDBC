package com.vc.factory;

import com.vc.dao.IStudentDao;
import com.vc.dao.StudentDaoImpl;

public class StudentDaoFactory {

	private static IStudentDao dao;
	static
	{
		dao=new StudentDaoImpl();
	}
	
	public static IStudentDao getStudentDao()
	{
		return dao;
	}
}
