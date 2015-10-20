package com.pvn.aspect;

/**
 * 
 * @author Praveen
 * (*) one arguments of any type 
 * (..) zero or any arguments of any type <-- Supermost condition
 * () No arguments
 *
 */


//@Component
//@Aspect
public class LoggingAspect 
{
	/**
	 * Demo1
	 */
	
//	@Before("execution(public void setName(*))")
	public void afterSetAdvice()
	{
		System.out.println("Advice Run. setName with one argument");
	}
	
// 	@Before("execution(public * *Name(..))")
	public void loggingGetOrSetAdvice()
	{
		System.out.println("Advice Run. GetName or SetName with zero or any argument");
	}


	/**
	 * PointCuts
	 */
/*	@Pointcut("execution(public String getName())")
	public void getAllGetNames(){}
	
	@Pointcut("execution(public void setName(*))")
	public void getAllSetNames(){}
	
	@Pointcut("within(com.pvn.model.Triangle)")
	public void getAllMethodsInTriangle(){}
	
	@Pointcut("within(com.pvn.model.Circle)")
	public void getAllMethodsInCircle(){}

	*/
	
	/**
	 * Demo3
	 */
//	@Before("getAllMethodsInCircle() && getAllGetNames()")
	public void circleGettersLoggingAdvice(){
		System.out.println("Advice Run. Circles getter method");
	}
		
//	@Before("getAllMethodsInTriangle() && getAllGetNames()")
	public void triangleGettersLoggingAdvice(){
		System.out.println("Advice Run. Triangles getter method");
	}
	
//	@Before("getAllMethodsInCircle() && getAllSetNames()")
	public void circleSettersLoggingAdvice(){
		System.out.println("Advice Run. Circles setter method");
	}
	
//	@Before("getAllMethodsInTriangle() && getAllSetNames()")
	public void triangleSettersLoggingAdvice(){
		System.out.println("Advice Run. Triangles setter method");
	}
	
}
