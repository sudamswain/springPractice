package com.pvn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class HelloWorldController implements Controller
{
	public ModelAndView handleRequest(HttpServletRequest req,
	HttpServletResponse resp) throws Exception 
	{
		System.out.println("Handling Request");
		String message=req.getParameter("name");
		return new ModelAndView("success","message",message);
	}
	
}
