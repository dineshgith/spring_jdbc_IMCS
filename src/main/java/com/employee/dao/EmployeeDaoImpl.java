package com.employee.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;
import com.employee.interf.EmployeeDao;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	JdbcTemplate jt;

	public boolean addEmployee(Employee employee) {

		String SQL = "insert into employees (id, name, salary, department, experience) values (?, ?)";
		jt.update(SQL, employee.getEmpId(), employee.getName(), employee.getSalary(), employee.getDeptNo(),
				employee.getExperience());
		return true;

	}

	public boolean updateEmployee(Employee employee, int empId) {
		String SQL = "update employees set name=? , salary= ?, department= ?, experience=?  where id=?";
		jt.update(SQL, employee.getName(), employee.getSalary(), employee.getDeptNo(), employee.getExperience(), empId);
		return true;

	}

	public boolean deleteEmployee(int empId) {
		String SQL = "delelte from employees where id=?";
		jt.update(SQL, empId);
		return true;

	}

}
