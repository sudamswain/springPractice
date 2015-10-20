package com.pvn;

import java.util.HashMap;
import java.util.Map;

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
		String name=req.getParameter("name");
		Map<String, String> map=new HashMap<String, String>();
		map.put("name", name);
		map.put("impl", "ControllerClassNameHandlerMapping");
		ModelAndView modelAndView=new ModelAndView("greeting","map",map);
		return modelAndView;
	}
	
}
