package com.github.itsAkshayDubey.aopwithspringpart1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.itsAkshayDubey.aopwithspringpart1.exception.EmployeeNotFoundException;
import com.github.itsAkshayDubey.aopwithspringpart1.model.Employee;
import com.github.itsAkshayDubey.aopwithspringpart1.service.impl.EmployeeServiceImplementation;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImplementation employeeServiceImplementation;
	
	@PostMapping("/employees")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeServiceImplementation.addEmployee(employee);
	}
	
	@GetMapping("/employees/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) throws EmployeeNotFoundException{
		Employee employee = employeeServiceImplementation.getEmployeeById(id)
				.orElseThrow(() -> 
				new EmployeeNotFoundException("Employee with ID "+id+" not found."));
		
		return ResponseEntity.ok().body(employee);
		
	}
	
	
}
