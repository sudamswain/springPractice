package com.pvn.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Component
@Aspect
public class AroundAdviceAspect 
{
	@Around(value = "execution(* setFullName(*,*))")
	public void allAdvices(ProceedingJoinPoint proceedingJoinPoint)
	{
		try 
		{
			System.out.println("before setName ==> @Before");
			proceedingJoinPoint.proceed();
			System.out.println("After successfull return ==> @AfterReturning");
		}
		catch (Throwable e)
		{
			System.out.println("After throwing exception ==>@AfterThrowing");
		}
		finally
		{
			System.out.println("Finally ==> @After");
		}
	}
}
