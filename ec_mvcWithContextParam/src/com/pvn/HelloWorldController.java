package com.pvn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.pvn.model.Circle;


public class HelloWorldController implements Controller
{
	public ModelAndView handleRequest(HttpServletRequest req,
	HttpServletResponse resp) throws Exception 
	{
		System.out.println("This DispatcherServlet is configured with init param " +
				"contextConfigLocation with value /WEB-INF/initparam.xml +"
				+ "And also Context param with contextparam.xml + Listener with org.springframework.web.context.ContextLoaderListener");
		String message=req.getParameter("name");
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(req.getServletContext());
		Circle circle = (Circle) ctx.getBean("circle");
		System.out.println(circle.getName());
		return new ModelAndView("success","message",message);
	}
	
}
