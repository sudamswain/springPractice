package com.pvn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.UrlFilenameViewController;

import com.pvn.dao.EmployeeJdbcDaoImpl;

public class PageProviders extends UrlFilenameViewController 
{
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("view extracted from url by UrlFilenameViewController"+this.getViewNameForRequest(request));
		Map<String, Object> map=new HashMap<>();
		EmployeeJdbcDaoImpl employeeJdbcDaoImpl=(EmployeeJdbcDaoImpl)this.getApplicationContext().getBean("employeeJdbcDaoImpl");
		List<String> jobs=employeeJdbcDaoImpl.getAllJobs();
		List<String> depts=employeeJdbcDaoImpl.getAllDepartmentts();
		List<Map<String, Object>> mgrs=employeeJdbcDaoImpl.getAllManagers();
		map.put("jobs", jobs);
		map.put("mgrs", mgrs);
		map.put("depts", depts);
		return new ModelAndView(this.getViewNameForRequest(request),"map",map);
	}
}
