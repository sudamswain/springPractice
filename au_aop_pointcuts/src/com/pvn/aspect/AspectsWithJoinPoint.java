package com.pvn.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.pvn.model.Circle;

@Component
@Aspect
public class AspectsWithJoinPoint 
{
	@Before("getCirclesAllMethod()")
	public void loggingAdvice(JoinPoint joinPoint){
	/*	System.out.println("toString "+joinPoint.toString());
		System.out.println("toShortString "+joinPoint.toShortString());
		System.out.println("toLongString "+joinPoint.toLongString());
		System.out.println("getTarget "+joinPoint.getTarget());
		System.out.println("getKind "+joinPoint.getKind());
		System.out.println("getStaticPart "+joinPoint.getStaticPart().toString());*/
		
		Circle circle=(Circle) joinPoint.getTarget();
		System.out.println("Advice Run. Using joinPoint.getTarget to get name : "+circle.getName());
	}
	
/*	@Before("args(name)")
	public void nameSetLoggingAdvice(String name)
	{
		System.out.println("Advice Run. Name has been set and the value is : "+name);
	}*/
	
	@Pointcut("within(com.pvn.model.Circle)")
	public void getCirclesAllMethod(){}
	
}
