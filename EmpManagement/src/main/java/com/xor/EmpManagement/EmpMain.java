package com.xor.EmpManagement;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmpMain {
	
	

	public static void main(String[] args) {

		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		
		EmpService ep = ac.getBean(EmpService.class);
		

		System.out.println("Welcome to Employee Management Application");

		
		while(true) {

			
			System.out.println("1.List of All Employees:");
			System.out.println("2.Fetch single employee details");
			System.out.println("3.Add New Employee");
			System.out.println("Enter 0 to quit");
			
			Scanner sc= new Scanner(System.in);
			
			String ch= sc.nextLine();
			
			
			switch(ch) {
			
			case "1":
				System.out.println("===List of All Employees====");
				System.out.println("-------------------");
				List<Employee> list = ep.getEmployees();
				 for (Employee emp : list)
				    {
				        System.out.println("Employee Id - "+emp.getEmpNo()+"| Employee Name - "+emp.getEmpName()+"| Employee Designation -"+emp.getPosition());
				        System.out.println("---------------------------------------------------------------");
				    }
				break;
				
			case "2":
				System.out.println("===Fetch single employee details======");
				System.out.println("-------------------");
				System.out.println("Enter Employee  Id : ");
				Scanner sca = new Scanner(System.in);
				String id = sca.next();
				Employee emp = ep.getSingleEmployee(id);
				if(emp!=null) {
				System.out.println("Employee Id - "+emp.getEmpNo()+"| Employee Name - "+emp.getEmpName()+"| Employee Designation -"+emp.getPosition());
				}else {
					System.out.println("Employee Not Found. Please Enter valid Id");
				}
				System.out.println("---------------------------------------------------------------");
				break;
				
				
			case "3":
				System.out.println("===Add New Employee to the database====");
				System.out.println("-------------------");
				
				System.out.println("Enter Employee  id : ");
				String Id = sc.nextLine();
				System.out.println("Enter Employee  Name : ");
				String name= sc.nextLine();
				System.out.println("Enter Employee  Designation : ");
				String Designation = sc.nextLine();
				ep.addEmployee(new Employee(Id, name, Designation));
				break;
				
			case "0":
				System.out.println("Thanks for visiting us");
				System.exit(0);
				break;	
				
			default:   
	            System.out.println("Please Enter correct input");  	

			
			}

		}
		


	}

	
	
	

}
