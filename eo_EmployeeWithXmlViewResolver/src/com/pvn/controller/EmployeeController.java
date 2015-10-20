package com.pvn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import com.pvn.dao.EmployeeService;
import com.pvn.model.Employee;

@SuppressWarnings("deprecation")
public class EmployeeController extends SimpleFormController 
{
	private EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public EmployeeController() 
	{
		setCommandName("employee");
		setCommandClass(Employee.class);
		System.out.println("EmployeeController constt");
		setValidator(new EmployeeValidator());
		setFormView("insert");
	}
	
	@Override
	protected Map<String, Object> referenceData(HttpServletRequest request) throws Exception 
	{
		System.out.println("creating job,mgr,dept map");
		System.out.println("Backing Object");
		Map<String, Object> map=new HashMap<>();
		List<String> jobs=employeeService.getAllJobs();
		List<String> depts=employeeService.getAllDepartmentts();
		List<Map<String, Object>> mgrs=employeeService.getAllManagers();
		map.put("jobs", jobs);
		map.put("mgrs", mgrs);
		map.put("depts", depts);
		return map;
	}
	
	
	@Override 
	protected ModelAndView onSubmit(HttpServletRequest request,
	HttpServletResponse response, Object command, BindException errors)
	throws Exception {
		System.out.println("Onsubmit");
		Employee employee=(Employee)command;
		System.out.println(employee.getEmpno());
		System.out.println(employee.getEname());
		employeeService.insertEmployee(employee);
		System.out.println("Inserted successfully");
//		return new ModelAndView("redirect4index");
		return new ModelAndView("indexRedirect");
	}
}
