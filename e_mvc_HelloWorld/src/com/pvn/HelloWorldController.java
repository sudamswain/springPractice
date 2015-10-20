package com.pvn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

@Controller

public class HelloWorldController 
{

	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public ModelAndView sayHelloWorld(HttpServletRequest req,HttpServletResponse resp)
	{
		String message=req.getParameter("name");
		System.out.println("@RequestMapping stuff "+message);
		return new ModelAndView("success","message",message);
	}
}
