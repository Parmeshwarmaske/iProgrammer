package com.cjc.service;

import com.cjc.model.Department;

public interface DepartmentService {
	
	public Department getStudentByDepartment(int rollno, String deptname);

}
