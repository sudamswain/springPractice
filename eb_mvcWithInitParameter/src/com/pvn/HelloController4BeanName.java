package com.pvn;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class HelloController4BeanName implements Controller
{
	public ModelAndView handleRequest(HttpServletRequest req,
	HttpServletResponse resp) throws Exception 
	{
		System.out.println("This DispatcherServlet is configured with init param " +
				"ContextConfigLocation with value /WEB-INF/initparam.xml ");
		System.out.println("Handling Request using BeanNameUrlHandlerMapping");
		String name=req.getParameter("name");
		Map<String, String> map=new HashMap<String, String>();
		map.put("name", name);
		map.put("impl", "BeanNameUrlHandlerMapping");
		return new ModelAndView("hello","map",map);
	}
}
