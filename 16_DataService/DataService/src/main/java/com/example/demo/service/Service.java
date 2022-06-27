package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Branches;
import com.example.demo.repo.BranchRepository;

@org.springframework.stereotype.Service
public class Service {

	@Autowired
	BranchRepository branchRepository;

	public Branches createBranch(Branches branch) {
		return branchRepository.save(branch);
	}

	public Branches updateBranch(Branches branch) throws DataNotFoundException {
		Optional<Branches> branchDb = this.branchRepository.findById(branch.getId());

		if (branchDb.isPresent()) {
			Branches barnchUpdate = branchDb.get();
			barnchUpdate.setId(branch.getId());
			barnchUpdate.setName(branch.getName());
			branchRepository.save(barnchUpdate);
			return barnchUpdate;
		} else {
			throw new DataNotFoundException("Record not found with id : " + branch.getId());
		}
	}

	public List<Branches> getAllBranch() {
		return this.branchRepository.findAll();
	}

	public Branches getBranchById(long BranchId) throws DataNotFoundException {

		Optional<Branches> BranchDb = this.branchRepository.findById(BranchId);

		if (BranchDb.isPresent()) {
			return BranchDb.get();
		} else {
			throw new DataNotFoundException("Record not found with id : " + BranchId);
		}
	}

	public void deleteBranch(long branchId) throws DataNotFoundException {
		Optional<Branches> BranchDb = this.branchRepository.findById(branchId);

		if (BranchDb.isPresent()) {
			this.branchRepository.delete(BranchDb.get());
		} else {
			throw new DataNotFoundException("Record not found with id : " + branchId);
		}

	}
}
