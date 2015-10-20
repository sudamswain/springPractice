package com.pvn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;


public class HelloWorldController extends AbstractController
{
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
	HttpServletResponse resp) throws Exception 
	{
		System.out.println("Handling Request");
		String message=req.getParameter("name");
		return new ModelAndView("success","message",message);
	}
}
