package com.pvn.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect 
{
//	@Before("execution(* *())")
//	@Before("execution(public * *())")
//	@Before("execution(public * get*())")
//	@Before("execution(public String get*())")
//	@Before("execution(public String getName())")
//	@Before("execution(public int getArea())")
//	@Before("execution(public * com.pvn.model.Circle.getArea())")
//	@Before("execution(public * com.pvn.model.Triangle.getArea())")
//	@Before("execution(public * com.pvn.model.Circle.get*())")
//	@Before("execution(public * com.pvn.service.ShapeService.get*())")
	@Before("execution(public * com.pvn.*.*.get*())")
	public void LogAdvice()
	{
		System.out.println("Advice Run : Getter called");
	}
}
