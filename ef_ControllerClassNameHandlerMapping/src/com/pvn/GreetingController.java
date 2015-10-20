package com.pvn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class GreetingController extends AbstractController 
{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
	HttpServletResponse resp) throws Exception 
	{
		System.out.println("Handling Request using ControllerClassNameHandlerMapping");
		String message=req.getParameter("name");
		ModelAndView modelAndView=new ModelAndView("greeting","message",message);
		return modelAndView;
	}
	
}
