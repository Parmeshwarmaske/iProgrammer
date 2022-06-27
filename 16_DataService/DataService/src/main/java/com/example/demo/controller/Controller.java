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
import com.example.demo.entity.Branches;
import com.example.demo.service.DataNotFoundException;
import com.example.demo.service.Service;

@RestController
@RequestMapping("/org")
public class Controller {
	
	
	@Autowired
	Service service;
	
	@GetMapping("/branches")
    public  List<Branches> getAllBranch() {
		System.out.println("Working ok");
        return  service.getAllBranch();
    }

    @GetMapping("/branches/{id}")
    public ResponseEntity < Branches > getBranchById(@PathVariable long id) throws DataNotFoundException {
        return ResponseEntity.ok().body(service.getBranchById(id));
    }

    @PostMapping("/branches")
    public ResponseEntity < Branches > createBranch(@RequestBody Branches employee) {
        return ResponseEntity.ok().body(this.service.createBranch(employee));
    }

    @PutMapping("/branches/{id}")
    public ResponseEntity < Branches > updateBranch(@PathVariable long id, @RequestBody Branches employee) throws DataNotFoundException {
        employee.setId(id);
        return ResponseEntity.ok().body(this.service.updateBranch(employee));
    }

    @DeleteMapping("/branches/{id}")
    public HttpStatus deleteBranch(@PathVariable long id) throws DataNotFoundException {
      service.deleteBranch(id);
        return HttpStatus.OK;
    }
} 
	
	
	
