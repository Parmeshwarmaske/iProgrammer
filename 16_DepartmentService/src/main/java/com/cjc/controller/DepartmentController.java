package com.cjc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.model.Department;
import com.cjc.service.DepartmentService;

@RestController
@RequestMapping("/departments")
class DepartmentController {
	
	@Autowired
	private DepartmentService deptService;
	
	@RequestMapping("/{deptname}/students/{rollno}")
	public Department getStudentByDept(@PathVariable String deptname, @PathVariable int rollno) {
		return deptService.getStudentByDepartment(rollno,deptname);
	}
	

}
