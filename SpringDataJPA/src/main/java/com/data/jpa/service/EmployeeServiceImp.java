package com.data.jpa.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.data.jpa.entity.Employee;
import com.data.jpa.repository.EmployeeRepo;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImp implements IEmployeeService {
	
	@Autowired
	EmployeeRepo repo;

	@Override
	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return repo.save(emp);
	}

	@Override
	public Employee getById(int eid) {
		// TODO Auto-generated method stub
		return repo.findById(eid).orElse(null);
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll(Sort.by(Direction.ASC,"salary"));
	}

	@Override
	public Employee updateEmp(Employee emp) {
		// TODO Auto-generated method stub
		return repo.save(emp);
	}

	@Override
	public void deleteEmpById(int eid) {
		// TODO Auto-generated method stub
		repo.deleteById(eid);
		
	}

	@Override
	public List<Employee> findByename(String ename) {
		// TODO Auto-generated method stub
		return repo.findByename(ename);
	}

	@Override
	public List<Employee> getBySalaryRange(double low, double high) {
		// TODO Auto-generated method stub
		return repo.getBySalaryRange(low, high);
	}

	@Override
	public List<Employee> findBySalaryGreaterThan(double salary) {
		// TODO Auto-generated method stub
		return repo.findBySalaryGreaterThan(salary);
	}

	@Override
	public List<Employee> findBySalaryLessThan(double salary) {
		// TODO Auto-generated method stub
		return repo.findBySalaryLessThan(salary);
	}

	@Override
	@Transactional // to begin transaction before any dml operation
	public int update(int empid) {
		// TODO Auto-generated method stub
		return repo.update(empid);
	}

	@Override
	@Transactional 
	public int insert(int eid, String ename, double salary) {
		// TODO Auto-generated method stub
		return repo.insertUser(eid, ename, salary);
	}

	/*@Override
	public List<Employee> findname(String letter) {
		// TODO Auto-generated method stub
		return repo.findname(letter);
	}*/

}
