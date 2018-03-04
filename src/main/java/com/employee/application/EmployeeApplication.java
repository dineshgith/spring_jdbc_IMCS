package com.employee.application;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.employee.configuration.EmployeeConfiguration;
import com.employee.entity.Employee;
import com.employee.interf.EmployeeService;
import com.employee.service.EmployeeServiceImpl;

public class EmployeeApplication {

	ApplicationContext ac = null;
	EmployeeService es = null;

	private void addEmployee(Scanner sc) {
		Employee employee = new Employee();
		System.out.println("Enter Employee name, Ex:Bravo");
		String name = sc.next();
		employee.setName(name);
		System.out.println("Enter Employee ID");
		int id = sc.nextInt();
		employee.setEmpId(id);
		System.out.println("Enter Employee Salary, Ex:76773");
		int salary = sc.nextInt();
		employee.setSalary(salary);
		System.out.println("Enter Employee Department#, Ex: 121");
		int dept = sc.nextInt();
		employee.setDeptNo(dept);
		System.out.println("Enter Employee Experience, Ex: 5.5");
		float exp = sc.nextFloat();
		employee.setExperience(exp);
		es.addEmployee(employee);

	}

	private void updateEmployee(Scanner sc) {
		Employee empl = new Employee();
		System.out.println("Enter ID of an Employee you want to update");
		int id = sc.nextInt();
		System.out.println("Enter name of an Employee, Ex:Bravo");
		String name = sc.next();
		empl.setName(name);
		System.out.println("Enter Employee Salary, Ex:76773");
		int salary = sc.nextInt();
		empl.setSalary(salary);
		System.out.println("Enter Employee Department#, Ex: 121");
		int dept = sc.nextInt();
		empl.setDeptNo(dept);
		System.out.println("Enter Employee Experience, Ex: 5.5");
		float exp = sc.nextFloat();
		empl.setExperience(exp);

		es.updateEmployee(empl, id);
	}

	private void deleteEmployee(Scanner sc) {
		System.out.println("Enter ID of an Employee");
		int id = sc.nextInt();
		es.deleteEmployee(id);

	}

	public static void main(String[] args) {
		EmployeeApplication ea = new EmployeeApplication();
		ea.ac = new AnnotationConfigApplicationContext(EmployeeConfiguration.class);
		ea.es = ea.ac.getBean(EmployeeServiceImpl.class);

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1. CREATE an Employee");
			System.out.println("2. DELETE an Employee");
			System.out.println("3. UPDATE an Employee");
			System.out.println("\n");
			System.out.println("Please Enter your choice.....");
			int selector = sc.nextInt();
			switch (selector) {
			case 1:
				ea.addEmployee(sc);
				break;

			case 2:
				ea.deleteEmployee(sc);
				break;

			case 3:
				ea.updateEmployee(sc);
				break;

			}
		}

	}

}
