package com.github.itsAkshayDubey.aopwithspringpart1.service.intf;

import com.github.itsAkshayDubey.aopwithspringpart1.model.Employee;

public interface EmployeeServiceInterface {
	Employee getEmployeeById(Integer id);
	Employee addEmployee(Employee employee);
}
