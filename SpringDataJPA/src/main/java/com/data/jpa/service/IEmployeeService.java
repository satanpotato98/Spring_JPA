package com.data.jpa.service;

import java.util.List;

import com.data.jpa.entity.Employee;

public interface IEmployeeService {

	public Employee addEmployee(Employee emp);
	public Employee getById(int eid);
	public List<Employee> getAll();
	public Employee updateEmp(Employee emp);
	public void deleteEmpById(int eid);
	public List<Employee> findByename(String ename);
	public List<Employee> getBySalaryRange(double low, double high);
	public List<Employee> findBySalaryGreaterThan(double salary);
	public List<Employee> findBySalaryLessThan(double salary);
	//public List<Employee> findname(String letter);
	public int  update(int empid);
	public int insert(int eid, String ename, double salary);
}
