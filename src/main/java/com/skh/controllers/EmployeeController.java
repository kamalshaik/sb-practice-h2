package com.skh.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skh.model.Address;
import com.skh.model.Employee;
import com.skh.repository.EmployeeRepository;
import com.skh.service.IEmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;

@RestController
@Tag(name = "Employee", description = "employee related functionality")
public class EmployeeController {

	@Autowired
	private IEmployeeService empService;

	@Autowired
	private EmployeeRepository empRepo;

	@GetMapping("/dummyData")

	@Operation(summary = "Fetch all dummy employees configured", 
			description = "Other info Fetch all dummy employees configured")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "successful operation") })
	public Employee fetchDummydata() {

		return testDatasave();

	}

	@GetMapping("/fetchDBData")
//	@ApiOperation(value = "fetching all employee details.")
	public List<Employee> fetchAlldata() {

		return (List<Employee>) empRepo.findAll();

	}

	@PostMapping("/storeEMpDetails")
//	@ApiOperation(value = "storing / saving employee details.")
	public void storedata(@RequestBody() Employee employee) {

		empRepo.save(employee);

	}

	private Employee testDatasave() {
		Address address1 = new Address(1, "1", "PSN", "Hyd", "TG", 534456);
		Address address2 = new Address(2, "2", "BVG", "ELR", "AP", 123456);
		// Address address3 = new Address(1, "3", "GB", "BGR", "KA", 534123);
		return new Employee(1, "Kamal", new Date(), 1234d, true, List.of(address1, address2));
	}

	@GetMapping("/")
	public Iterable<Employee> fetchAllEmployeeDetails() {

		Sort emailSort = Sort.by("empSalary");
		Sort firstNameSort = Sort.by("empId");

		Sort groupBySort = emailSort.and(firstNameSort).descending();

		Iterable<Employee> result = empRepo.findAll(groupBySort);

		return result;
	}

	@GetMapping("/pagination/{empName}/{offset}/{size}")
//	@ApiOperation(value = "stesting pagination")
	public Iterable<Employee> findByEmpName(@PathVariable String empName, @PathVariable Integer offset,
			@PathVariable() Integer size) {
		// http://127.0.0.1:9000/pagination/Kamal/0/2
//		http://127.0.0.1:9000/pagination/Kamal/1/2

		Iterable<Employee> result = empRepo.findByEmpName(empName, PageRequest.of(offset, size));

		return result;
	}

}
