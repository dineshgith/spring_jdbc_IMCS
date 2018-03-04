package com.employee.interf;

import com.employee.entity.Employee;

public interface EmployeeDao {
	public boolean addEmployee(Employee employee);

	public boolean updateEmployee(Employee employee, int empId);

	public boolean deleteEmployee(int empId);

}
