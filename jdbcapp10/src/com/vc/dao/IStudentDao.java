package com.vc.dao;

import com.vc.bean.Student;

public interface IStudentDao {

	public String add(Student std);
	public String delete(int sid);
	public String update(Student std);
	public Student search(int sid);
}
