package com.xor.EmpManagement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class EmpOperations {
	
	 private static  Map<String, Employee> empMap = new LinkedHashMap<String, Employee>();
	 
	  static {
	        initEmps();
	    }

	    private static void initEmps() {
	        Employee emp1 = new Employee("E100", "Mac", "Clerk");
	        Employee emp2 = new Employee("E101", "Allen", "Salesman");
	        Employee emp3 = new Employee("E102", "Jhon", "Manager");

	        empMap.put(emp1.getEmpNo(), emp1);
	        empMap.put(emp2.getEmpNo(), emp2);
	        empMap.put(emp3.getEmpNo(), emp3);
	    }
	    
	    
	    public static List<Employee> getAllEmployees() {
	        Collection<Employee> c = empMap.values();
	        List<Employee> list = new ArrayList<Employee>();
	        list.addAll(c);
	        return list;
	    }
	    
	    
	    public static Employee getEmployee(String empNo) {
	        return empMap.get(empNo);
	    }

	    public static Employee addEmployee(Employee emp) {
	        empMap.put(emp.getEmpNo(), emp);
	        System.out.println("Employee has been added successfully");
	        System.out.println("-----------------------------------------");
	        return emp;
	    }
	    
	  
	
	}


