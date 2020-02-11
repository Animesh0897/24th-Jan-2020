package com.ibm.eis.ui;

import com.ibm.eis.service.*;
import com.ibm.eis.bean.Employee;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			
		
		System.out.println("Enter 1: For adding an Employee");
		System.out.println("Enter 2: For finding an Employee ");
		System.out.println("Enter 3 :For displaying all dtaa in database");
		System.out.println("Enter 4: to Exit");
		
		int n1 = sc.nextInt();
		sc.nextLine();
		if (n1==1)
		{
			EmpServiceInterface EmpService = new EmpServiceClass();

			String insuranceScheme;
			String name;
			System.out.println("Enter name: ");
			name = sc.nextLine();

			String designation;
			System.out.println("Enter designation");
			designation = sc.nextLine();

			int id;
			System.out.println("Enter id: ");
			id = sc.nextInt();

			double salary;
			System.out.println("Enter salary: ");
			salary = sc.nextDouble();
			sc.nextLine();
			EmpServiceClass ob1 = new EmpServiceClass();

			insuranceScheme = ob1.ScehemeChecker(salary, designation);

			System.out.println("The insurance Scheme is :" + insuranceScheme);
			Employee employee = new Employee();

			employee.setName(name);
			employee.setDesignation(designation);
			employee.setId(id);
			employee.setSalary(salary);
			employee.setInsuranceScheme(insuranceScheme);

			EmpService.storeIntoMap(employee);
			System.out.println(EmpService.displayEmployees() + "/n");

			
		}
//			else if(n1==2)
//		{
//			EmpServiceInterface EmpService = new EmpServiceClass();
//
//			System.out.println("Enter the employee id of employee");
//			
//			int id = sc.nextInt();
//			sc.nextLine();
//			System.out.println(EmpService.displayEmployees().get(id));
//		}
//		
//		else if(n1==3)
//		{
//			EmpServiceInterface EmpService = new EmpServiceClass();
//
//			System.out.println(EmpService.displayEmployees());
//
//			
//		}
		else
		{
			break;
		}
		}
		
		
		
		// System.out.println(DaoInterface.persons);


		
	}
}
