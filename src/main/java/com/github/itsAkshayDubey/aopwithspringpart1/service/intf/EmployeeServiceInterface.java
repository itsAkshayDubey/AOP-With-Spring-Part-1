package com.github.itsAkshayDubey.aopwithspringpart1.service.intf;

import java.util.Optional;

import com.github.itsAkshayDubey.aopwithspringpart1.exception.EmployeeNotFoundException;
import com.github.itsAkshayDubey.aopwithspringpart1.model.Employee;

public interface EmployeeServiceInterface {
	Optional<Employee> getEmployeeById(Integer id) throws EmployeeNotFoundException;
	Employee addEmployee(Employee employee);
}
