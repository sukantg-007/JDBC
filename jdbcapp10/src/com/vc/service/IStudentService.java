package com.vc.service;

import com.vc.bean.Student;

public interface IStudentService {

	String addStudent(Student std);
	String deleteStudent(int sid);
	String updateStudent(Student std);
	public Student searchStudent(int sid);
}
