package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Branches;

@FeignClient(value  = "data-client-service", url="http://localhost:8082/org")
public interface DataServiceClient {
	
	    @GetMapping("/branches/{id}")
	    public ResponseEntity < Branches > getBranchById(@PathVariable long id);
}
