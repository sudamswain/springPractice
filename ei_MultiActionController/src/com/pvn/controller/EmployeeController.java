package com.pvn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class EmployeeController extends MultiActionController
{
	public ModelAndView empSave(HttpServletRequest req,HttpServletResponse resp)
	{
		System.out.println("empSave() method");
		return null;
	}
	
	public ModelAndView empUpdate(HttpServletRequest req,HttpServletResponse resp)
	{
		System.out.println("empUpdate() method");
		return null;
	}
	
	public ModelAndView empDelete(HttpServletRequest req,HttpServletResponse resp)
	throws Exception 
	{
		System.out.println("empDelete() method");
		return null;
	}
}
