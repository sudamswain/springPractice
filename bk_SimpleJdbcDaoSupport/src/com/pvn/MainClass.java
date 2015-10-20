package com.pvn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pvn.dao.CircleDaoJdbcImpl;
import com.pvn.model.Circle;

public class MainClass 
{
	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		CircleDaoJdbcImpl circleDaoJdbcImpl = context.getBean("circleDaoJdbcImpl",CircleDaoJdbcImpl.class);
		System.out.println(circleDaoJdbcImpl.getCirclesCount());
		Circle circle=new Circle();
		circle.setCircleId(6);
		circle.setName("Third Circle");
		circleDaoJdbcImpl.inserIntoCircle(circle);
		System.out.println(circleDaoJdbcImpl.getCirclesCount());
	}
}
