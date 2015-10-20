package com.pvn.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

public class GreetingController extends ParameterizableViewController
{
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp)
	throws Exception 
	{
		System.out.println("Handling Request using ParameterizableViewController");
		String name=req.getParameter("name");
		Map<String, String> map=new HashMap<>();
		map.put("name",name);
		map.put("impl","ParameterizableViewController");
		return new ModelAndView(this.getViewName(), "map", map);
	}
}
