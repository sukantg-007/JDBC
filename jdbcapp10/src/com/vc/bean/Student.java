package com.vc.bean;

public class Student {
	private int sid;
	private String sname;
	private String saddr;
	private String smobile;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddr() {
		return saddr;
	}
	public void setSaddr(String saddr) {
		this.saddr = saddr;
	}
	public String getSmobile() {
		return smobile;
	}
	public void setSmobile(String smobile) {
		this.smobile = smobile;
	}
	@Override
	public String toString() {
		String msg=	"Student Information\n"+
					"Student Id : "+sid+"\n"+
					"Student Name : "+sname+"\n"+
					"Student Addr : "+saddr+"\n"+
					"Student Mobile : "+smobile;
		return msg;
	}
	
	

}
