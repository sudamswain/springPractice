package com.pvn.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 
 * @author Praveen
 * (*) one or any arguments
 * (..) zero or any arguments  <-- Supermost condition
 * () No arguments
 *
 */


//@Component
@Aspect
public class LoggingAspect 
{
	/**
	 * Demo1
	 */
	
	@Before("execution(public void setName(*))")
/*	public void afterSetAdvice()
	{
		System.out.println("Advice Run. setName with one argument");
	}
	
 	@Before("execution(public * *Name(..))")
	public void loggingGetOrSetAdvice()
	{
		System.out.println("Advice Run. GetName or SetName with zero or any argument");
	}*/


	/**
	 * Demo2
	 */
	
/* 	@Before("execution(public String getName())")
	public void loggingGetAdvice()
	{
		System.out.println("Advice Run. getName() method calling");
	}
	
	@Before("execution(public void setName(*))")
	public void loggingSetAdvice()
	{
		System.out.println("Advice Run. setName() method calling");
	}*/

	
	/**
	 * PointCuts
	 */
	@Pointcut("execution(public String getName())")
	public void getAllGetNames(){}
	
	@Pointcut("execution(public void setName(*))")
	public void getAllSetNames(){}
	
	@Pointcut("within(com.pvn.model.Triangle)")
	public void getAllMethodsInTriangle(){}
	
	@Pointcut("within(com.pvn.model.Circle)")
	public void getAllMethodsInCircle(){}
	
	/**
	 * Demo3
	 */
	@Before("getAllMethodsInCircle() && getAllGetNames()")
	public void circleGettersLoggingAdvice(){
		System.out.println("Advice Run. Circles getter method");
	}
		
	/**
	 * Demo4
	 */
	@Before("getAllMethodsInTriangle() && getAllGetNames()")
	public void triangleGettersLoggingAdvice(){
		System.out.println("Advice Run. Triangles getter method");
	}
	
	/**
	 * Demo5 
	 */
	@Before("getAllMethodsInCircle() && getAllSetNames()")
	public void circleSettersLoggingAdvice(){
		System.out.println("Advice Run. Circles setter method");
	}
	
	/**
	 * Demo6
	 */
	@Before("getAllMethodsInTriangle() && getAllSetNames()")
	public void triangleSettersLoggingAdvice(){
		System.out.println("Advice Run. Triangles setter method");
	}
	
}
