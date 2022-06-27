package com.cjc.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cjc.model.Department;
import com.cjc.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	

	@Override
	public Department getStudentByDepartment(int rollno, String deptname) {
		// to get the data from student service
		
		Map<String, Integer> uriVariables = new HashMap<>();
		uriVariables.put("rollno", rollno);
		
		ResponseEntity<Department> response = new RestTemplate().getForEntity("/students/{rollno}", Department.class, uriVariables);
		
		Department department = response.getBody();
		department.setDeptname(deptname);
		
		return department;
	}

}
