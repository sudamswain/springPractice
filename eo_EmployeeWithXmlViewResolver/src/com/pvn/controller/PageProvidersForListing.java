package com.pvn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import com.pvn.dao.EmployeeService;
import com.pvn.model.Employee;

public class PageProvidersForListing extends AbstractController
{
	private EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("PageProvidersForListing");
		Map<String, Object> map=new HashMap<>();
		List<Employee> employees=employeeService.getEmployeesList();
		for (Employee employee : employees) {
			System.out.println(employee.getMgr());
		}
		map.put("employees", employees);
		return new ModelAndView("index","map",map);
	}
}