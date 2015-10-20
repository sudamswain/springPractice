package com.pvn.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.pvn.model.Employee;

public class EmployeeValidator implements Validator {

	@SuppressWarnings("rawtypes")
	@Override
	public boolean supports(Class arg0) {
		System.out.println("Supports");
		return true;
	}

	@Override
	public void validate(Object emp, Errors error){
		System.out.println("Validating...");
		Employee employee=(Employee) emp;
		System.out.println(employee.getMgr());
		if(employee.getMgr()==0)
			employee.setMgr(null);
		System.out.println(employee.getMgr());
		if(employee.getEmpno() == null)
			error.reject("empno", "Employee Number can not be empty");
		else if(employee.getEmpno() < 0)
			error.reject("empno", "Employee Number can not be Negative");
		else if(employee.getEname() == null)
			error.reject("ename", "Employee name can not be empty");
		else if(employee.getEname().length() < 3)
			error.reject("ename", "Employee name should have atleast 3 letters");
		else if(employee.getSal() == null)
			error.reject("ename", "Employee salary can not be empty");
		else if(employee.getSal() < 0)
			error.reject("ename", "Employee Salary can not be Negative");
	}

}
