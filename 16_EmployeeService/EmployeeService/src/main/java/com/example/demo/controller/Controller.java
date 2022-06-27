 package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeNotFoundException;
import com.example.demo.service.Service;

@RestController
@RequestMapping("/admin")
public class Controller {
	
	
	@Autowired
	Service service;
	
	@GetMapping("/employees")
    public  List<Employee> getAllEmployee() {
        return  service.getAllEmployee();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity < Employee > getEmployeeById(@PathVariable long id) throws EmployeeNotFoundException {
        return ResponseEntity.ok().body(service.getEmployeeById(id));
    }

    @PostMapping("/employees")
    public ResponseEntity < Employee > createEmployee(@RequestBody Employee employee) throws Exception {
        return ResponseEntity.ok().body(this.service.createEmployee(employee));
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity < Employee > updateEmployee(@PathVariable long id, @RequestBody Employee employee) throws EmployeeNotFoundException {
        employee.setId(id);
        return ResponseEntity.ok().body(this.service.updateEmployee(employee));
    }

    @DeleteMapping("/employees/{id}")
    public HttpStatus deleteEmployee(@PathVariable long id) throws EmployeeNotFoundException {
      service.deleteEmployee(id);
        return HttpStatus.OK;
    }
}
	
	
	
