package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.interf.EmployeeDao;
import com.employee.interf.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao empImpl;

	public boolean addEmployee(Employee employee) {
		return empImpl.addEmployee(employee);
	}

	public boolean updateEmployee(Employee employee, int empId) {
		return empImpl.updateEmployee(employee, empId);

	}

	public boolean deleteEmployee(int empId) {
		return empImpl.deleteEmployee(empId);
	}
}
