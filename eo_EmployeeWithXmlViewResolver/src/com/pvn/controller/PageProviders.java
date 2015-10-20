package com.pvn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.pvn.dao.EmployeeService;

public class PageProviders extends AbstractController
{
	private EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("PageProviders for inserting");
		Map<String, Object> map=new HashMap<>();
		List<String> jobs=employeeService.getAllJobs();
		List<String> depts=employeeService.getAllDepartmentts();
		List<Map<String, Object>> mgrs=employeeService.getAllManagers();
		map.put("jobs", jobs);
		map.put("mgrs", mgrs);
		map.put("depts", depts);
		return new ModelAndView("insert","map",map);
	}
}
