package com.pvn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.InternalPathMethodNameResolver;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class EmployeeController extends MultiActionController
{
	/*
	 * You can use constructor to injecting dependency or you can configure in xml file
	 * by creating bean methodNameResolver with setters prefix and suffix
	 * written in xml file and commented it
	 */
	public EmployeeController() {
		InternalPathMethodNameResolver methodNameResolver=new InternalPathMethodNameResolver();
		methodNameResolver.setPrefix("praveen");
		methodNameResolver.setSuffix("Crud");
		setMethodNameResolver(methodNameResolver);
	}
	public ModelAndView praveenEmpSaveCrud(HttpServletRequest req,HttpServletResponse resp)
	{
		System.out.println("empSave() method");
		return null;
	}
	
	public ModelAndView praveenEmpUpdateCrud(HttpServletRequest req,HttpServletResponse resp)
	{
		System.out.println("empUpdate() method");
		return null;
	}
	
	public ModelAndView praveenEmpDeleteCrud(HttpServletRequest req,HttpServletResponse resp)
	throws Exception 
	{
		System.out.println("empDelete() method");
		return null;
	}
}
