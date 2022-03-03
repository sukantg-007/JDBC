package com.vc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.vc.bean.Student;
import com.vc.factory.ConnectionFactory;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public String add(Student std) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String msg="";
		try {
			con=ConnectionFactory.getConnection();
			st=con.createStatement();
			rs=st.executeQuery("SELECT * FROM STUDENT2 WHERE SID="+std.getSid());
			boolean available=rs.next();
			if(available==true) {
				msg="Record Already Avaialable";
			}else {
			int count=st.executeUpdate("INSERT INTO STUDENT2 VALUES ("+std.getSid()+",'"+std.getSname()+"','"+std.getSaddr()+"','"+std.getSmobile()+"')");
			msg=count>0?"Successfully Inserted..":"Fail to Insert..";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;		
	}

	@Override
	public String delete(int sid) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String msg="";
		try {
			con=ConnectionFactory.getConnection();
			st=con.createStatement();
			rs=st.executeQuery("SELECT * FROM STUDENT2 WHERE SID="+sid);
			boolean available=rs.next();
			if(available==false) {
				msg="Record Not Avaialable";
			}else {
			int count=st.executeUpdate("DELETE FROM STUDENT2 WHERE SID="+sid);
			msg=count>0?"Successfully Deleted..":"Fail to Delete..";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;	
	}

	

	@Override
	public Student search(int sid) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		Student std=null;
		try {
			con=ConnectionFactory.getConnection();
			st=con.createStatement();
			rs=st.executeQuery("SELECT * FROM STUDENT2 WHERE SID="+sid);
			boolean available=rs.next();
			if(available==false) {
				std=null;
			}else {				
					std=new Student();
					std.setSid(rs.getInt("sid"));
					std.setSname(rs.getString("sname"));
					std.setSaddr(rs.getString("saddr"));
					std.setSmobile(rs.getString("smobile"));				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return std;	
	}

	@Override
	public String update(Student std) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String msg="";
		try {
			con=ConnectionFactory.getConnection();
			st=con.createStatement();
			rs=st.executeQuery("SELECT * FROM STUDENT2 WHERE SID="+std.getSid());
			boolean available=rs.next();
			if(available==false) {
				msg="Record Not Avaialable";
			}else {
			int count=st.executeUpdate("UPDATE STUDENT2 SET SNAME='"+std.getSname()+"',SADDR='"+std.getSaddr()+"',SMOBILE='"+std.getSmobile()+"' WHERE SID="+std.getSid());
			msg=count>0?"Successfully Updated..":"Fail to Update..";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;	
	}



	

	
	
}
