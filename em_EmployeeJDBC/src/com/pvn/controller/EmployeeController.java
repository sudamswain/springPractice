package com.pvn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.pvn.dao.EmployeeJdbcDaoImpl;
import com.pvn.model.Employee;


public class EmployeeController extends MultiActionController
{
	public ModelAndView empSave(HttpServletRequest req,HttpServletResponse resp)
	{
		EmployeeJdbcDaoImpl employeeJdbcDaoImpl=(EmployeeJdbcDaoImpl)this.getApplicationContext().getBean("employeeJdbcDaoImpl");
		employeeJdbcDaoImpl.insertEmployee(employeeExtractor(req));
		System.out.println("Inserted successfully");
		return new ModelAndView("redirect");
	}
	
	public ModelAndView empUpdate(HttpServletRequest req,HttpServletResponse resp)
	{
		System.out.println("Employee Updating");
		return null;
	}
	
	private Employee employeeExtractor(HttpServletRequest req)
	{
		Employee emp=new Employee();
		emp.setEmpno(Integer.parseInt(req.getParameter("empno")));
		emp.setEname(req.getParameter("ename"));
		emp.setJob(req.getParameter("job"));
		emp.setMgr(req.getParameter("mgr").equalsIgnoreCase("select")?null:Integer.parseInt(req.getParameter("mgr")));
		emp.setHiredate(req.getParameter("hiredate"));
		emp.setSal(Integer.parseInt(req.getParameter("sal")));
		emp.setComm(req.getParameter("comm").isEmpty()?null:Integer.parseInt(req.getParameter("comm")));
		emp.setDeptno(Integer.parseInt(req.getParameter("deptno")));
		return emp;
	}
}
