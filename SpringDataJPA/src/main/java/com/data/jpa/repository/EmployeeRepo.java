package com.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.data.jpa.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	public List<Employee> findByename(String ename);
	
	@Query("from Employee e1 where e1.salary between ?1 and ?2 order by e1.ename")
	public List<Employee> getBySalaryRange(double low, double high);
	
	@Query("from Employee e1 where e1.salary > ?1 order by e1.salary")
	public List<Employee> findBySalaryGreaterThan(double salary);
	
	@Query("from Employee e1 where e1.salary < ?1 order by e1.ename")
	public List<Employee> findBySalaryLessThan(double salary);
	
	//@Query("from Employee e1 where e1.ename like ':letter%1'")
	//public List<Employee> findname(@Param("letter") String letter);
	
	@Modifying  // mandatory for any DML Operation
		@Query("update  Employee e set e.salary = 99000 where e.eid = :empid ")
		public int  update(@Param("empid")  int empid);
	
	@Modifying
	@Query(
	  value = 
	    "insert into jpa_employee (eid,empname,salary) values (:eid, :ename, :salary)",
	  nativeQuery = true)
		public int insertUser(@Param("eid") int eid, @Param("ename") String name, @Param("salary") double salary);
}
