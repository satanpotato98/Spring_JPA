package com.data.jpa.restcontroller;

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

import com.data.jpa.entity.Employee;
import com.data.jpa.service.IEmployeeService;

@RestController
@RequestMapping("/jpa/emp")
public class EmployeeController {

	@Autowired
	IEmployeeService service;
	
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee emp) {
		return service.addEmployee(emp);
	}
	@PutMapping("/update")
	public Employee updateEmp(@RequestBody Employee emp) {
		return service.updateEmp(emp);
	}
	
	
	@GetMapping("/getall")
	public List<Employee> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/get/eid/{eid}")
	public Employee getById(@PathVariable int eid) {
		return service.getById(eid);
	}
	
	@GetMapping("/get/ename/{ename}")
	public List<Employee> findByename(@PathVariable String ename) {
		return service.findByename(ename);
	}
	@GetMapping("/get/salary/{low}/{high}")
	public List<Employee> getEmpBtwSalary(@PathVariable double low, @PathVariable double high){
		return service.getBySalaryRange(low, high);
	}
	
	@GetMapping("/get/salary/>/{salary}")
	public List<Employee> findBysalaryGreaterThan(@PathVariable double salary){
		return service.findBySalaryGreaterThan(salary);
	}
	
	@GetMapping("/get/salary/</{salary}")
	public List<Employee> findBysalaryLessThan(@PathVariable double salary){
		return service.findBySalaryLessThan(salary);
	}
	
	/*@GetMapping("/get/like/{letter}")
	public List<Employee> findname(@PathVariable String letter){
		return service.findname(letter);
	}*/
	
	@DeleteMapping("delete/{eid}")
	public ResponseEntity<String> deleteById(@PathVariable int eid){
		service.deleteEmpById(eid);
		return new ResponseEntity<String>("employee deleted", HttpStatus.OK);
	}
	
	@PostMapping("/update/{eid}")
	public int  updateSalary(@PathVariable int eid) {
		
		return service.update(eid);
		
	}
	
	@PostMapping("/insert/{eid}/{ename}/{salary}")
	public int insertEmp(@PathVariable int eid, @PathVariable String ename, @PathVariable double salary) {
		return service.insert(eid, ename, salary);
	}
	
	
}
