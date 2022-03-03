package com.vc.service;

import com.vc.bean.Student;
import com.vc.dao.IStudentDao;
import com.vc.factory.StudentDaoFactory;

public class StudentServiceImpl implements IStudentService {

	@Override
	public String addStudent(Student std) {
		IStudentDao dao=StudentDaoFactory.getStudentDao();
		String msg=dao.add(std);
		return msg;
	}

	@Override
	public String deleteStudent(int sid) {
		IStudentDao dao=StudentDaoFactory.getStudentDao();
		String msg=dao.delete(sid);
		return msg;
	}

	@Override
	public String updateStudent(Student std) {
		IStudentDao dao=StudentDaoFactory.getStudentDao();
		String msg=dao.update(std);
		return msg;
	}

	@Override
	public Student searchStudent(int sid) {
		IStudentDao dao=StudentDaoFactory.getStudentDao();
		Student std =dao.search(sid);
		return std;
	}

}
