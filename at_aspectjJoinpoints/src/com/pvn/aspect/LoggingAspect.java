package com.pvn.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.pvn.model.Circle;

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
	@Before("allCircleMethod()")
	public void LogAdvice(JoinPoint joinPoint)
	{
		//System.out.println(joinPoint.toString());
		Circle circle=(Circle)joinPoint.getTarget();
		System.out.println("Advice run. Getting name of circle using join point"+circle.getName());

	}
	/*@Before("allGetters()")
	public void secondAdvice(){
		System.out.println("secondAdvice Run : Getter called");
	}*/
	
	@Pointcut("execution(public String get*())")
	public void allGetters(){}
	
	@Pointcut("within(com.pvn.model.Circle)")
	public void allCircleMethod(){
		
	}
}
