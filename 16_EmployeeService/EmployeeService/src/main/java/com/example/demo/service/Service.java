package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.client.DataServiceClient;
import com.example.demo.entity.Branches;
import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepository;

@org.springframework.stereotype.Service
public class Service {

//	@Autowired
	DataServiceClient client;

	@Autowired
	EmployeeRepository employeeRepository;

	public Employee createEmployee(Employee employee) throws Exception {
		ResponseEntity<Branches> barnch = client.getBranchById(1l);
		try {
			if (barnch.getStatusCode() == HttpStatus.valueOf((Integer) 200)) {
				return employeeRepository.save(employee);
			} else {
				throw new EmployeeNotFoundException("There is Probelem with Feign Call");
			}
		} catch (Exception e) {
			throw new Exception("Exception Occured ", e);
		}

	}

	public Employee updateEmployee(Employee Employee) throws EmployeeNotFoundException {
		Optional<Employee> EmployeeDb = this.employeeRepository.findById(Employee.getId());

		if (EmployeeDb.isPresent()) {
			Employee EmployeeUpdate = EmployeeDb.get();
			EmployeeUpdate.setId(Employee.getId());
			EmployeeUpdate.setName(Employee.getName());
			employeeRepository.save(EmployeeUpdate);
			return EmployeeUpdate;
		} else {
			throw new EmployeeNotFoundException("Record not found with id : " + Employee.getId());
		}
	}

	public List<Employee> getAllEmployee() {
		return this.employeeRepository.findAll();
	}

	public Employee getEmployeeById(long EmployeeId) throws EmployeeNotFoundException {

		Optional<Employee> EmployeeDb = this.employeeRepository.findById(EmployeeId);

		if (EmployeeDb.isPresent()) {
			return EmployeeDb.get();
		} else {
			throw new EmployeeNotFoundException("Record not found with id : " + EmployeeId);
		}
	}

	public void deleteEmployee(long EmployeeId) throws EmployeeNotFoundException {
		Optional<Employee> EmployeeDb = this.employeeRepository.findById(EmployeeId);

		if (EmployeeDb.isPresent()) {
			this.employeeRepository.delete(EmployeeDb.get());
		} else {
			throw new EmployeeNotFoundException("Record not found with id : " + EmployeeId);
		}

	}
}
