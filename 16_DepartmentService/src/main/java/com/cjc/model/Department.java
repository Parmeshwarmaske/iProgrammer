package com.cjc.model;

public class Department {
	
	private String deptname;
	private int rollno;
	private String name;
	
	public Department() {}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department(String deptname, int rollno, String name) {
		super();
		this.deptname = deptname;
		this.rollno = rollno;
		this.name = name;
	}
	
	

}
