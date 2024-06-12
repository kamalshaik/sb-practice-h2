package com.skh.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.skh.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	List<Employee> findByEmpName(String empName, Pageable pageble);
	List<Employee> findAll(Sort sortBy);

}
