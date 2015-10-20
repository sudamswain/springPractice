package com.pvn.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundAdviceAspect 
{
	@Around("@annotation(com.pvn.aspect.MakeAround)")
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
	
	@Around("@annotation(com.pvn.aspect.MakeBefore)")
	public void beforeAdvice(ProceedingJoinPoint proceedingJoinPoint)
	{
		try {
			System.out.println("Advice Run: before method ==> @Before");
			proceedingJoinPoint.proceed();
		}
		catch (Throwable e){}
		finally	{}
	}
	
	@Around("@annotation(com.pvn.aspect.MakeAfterReturning)")
	public void afterReturningAdvice(ProceedingJoinPoint proceedingJoinPoint)
	{
		try {
			proceedingJoinPoint.proceed();
			System.out.println("Advice Run: After successfull return ==> @AfterReturning");
		}
		catch (Throwable e){}
		finally	{}
	}
	
	@Around("@annotation(com.pvn.aspect.MakeAfter)")
	public void afterAdvice(ProceedingJoinPoint proceedingJoinPoint)
	{
		try {
			proceedingJoinPoint.proceed();
		}
		catch (Throwable e){}
		finally	{
			System.out.println("Advice Run: Finally ==> @After");
		}
	}
	
	@Around("@annotation(com.pvn.aspect.MakeAfterThrowing)")
	public void afterThrowing(ProceedingJoinPoint proceedingJoinPoint)
	{
		try {
			proceedingJoinPoint.proceed();
		}
		catch (Throwable e){
			System.out.println("Advice Run: After throwing exception ==>@AfterThrowing "+e);
		}
		finally	{}
	}
}
