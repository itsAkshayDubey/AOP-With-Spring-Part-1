package com.github.itsAkshayDubey.aopwithspringpart1.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.itsAkshayDubey.aopwithspringpart1.exception.EmployeeNotFoundException;
import com.github.itsAkshayDubey.aopwithspringpart1.model.Employee;
import com.github.itsAkshayDubey.aopwithspringpart1.repository.EmployeeRepository;
import com.github.itsAkshayDubey.aopwithspringpart1.service.intf.EmployeeServiceInterface;

@Service
public class EmployeeServiceImplementation implements EmployeeServiceInterface{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Optional<Employee> getEmployeeById(Integer id) throws EmployeeNotFoundException{
		return employeeRepository.findById(id);
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

}
