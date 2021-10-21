package com.xor.EmpManagement;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {

	@Autowired
	private EmpOperations emp;

	public List<Employee> getEmployees() {
		List<Employee> list = emp.getAllEmployees();

		return list;

	}

	public Employee getSingleEmployee(String empNo) {
		return emp.getEmployee(empNo);
	}

	public Employee addEmployee(Employee ep) {

		System.out.println("Adding  employee: " + ep.getEmpNo());

		return emp.addEmployee(ep);
	}

}
