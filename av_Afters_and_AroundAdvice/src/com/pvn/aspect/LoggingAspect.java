package com.pvn.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect 
{
	@Before("args(fn,ln)")
	public void beforeSetAdvice(String fn,String ln)
	{
		System.out.println("Advice Run. @Before advice : "+fn+" "+ln);
	}
	
	@After("args(fn,ln)")
	public void afterSetAdvice(String fn,String ln)
	{
		System.out.println("Advice Run. @After advice with values taken from args(x,y) : "+fn+" "+ln);
	}
	
	@AfterReturning(pointcut="args(fn,ln)",returning="fullName")
	public void afterReturningAdvice(String fn,String ln,String fullName)
	{
		System.out.println("Advice Run. @AfterReturning advice with returned value by returning='varName' : "+fullName);
	}
	
	@AfterThrowing(pointcut="args(fn,ln)",throwing="ex")
	public void afterReturningAdvice(String fn,String ln,Throwable ex)
	{
		System.out.println("Advice Run. @AfterThrowing advice with throwable arg : "+ex);
	}
}