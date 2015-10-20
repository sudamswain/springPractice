package com.pvn.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

//@Component
//@Aspect
public class AroundAdviceAspect 
{

	//@Around("allGetters()")
	public void allAdvices(ProceedingJoinPoint proceedingJoinPoint)
	{
		try 
		{
			System.out.println("Advice Run: before setName ==> @Before");
			proceedingJoinPoint.proceed();
			System.out.println("Advice Run: After successfull return ==> @AfterReturning");
		}
		catch (Throwable e)
		{
			System.out.println("Advice Run: After throwing exception ==>@AfterThrowing "+e);
		}
		finally
		{
			System.out.println("Advice Run: Finally ==> @After");
		}
	}
/*
	@Pointcut("execution(public String get*())")
	public void allGetters(){}*/
	
}
