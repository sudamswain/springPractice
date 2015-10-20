package com.pvn;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pvn.dao.CircleDaoJDBCImpl;
import com.pvn.model.Circle;

public class JdbcDemo 
{
	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		CircleDaoJDBCImpl circleJdbcImpl=ctx.getBean("circleDaoJDBCImpl", CircleDaoJDBCImpl.class);
		System.out.println("------Using queryForInt()-------");
	   	System.out.println("Total circles count is : "+circleJdbcImpl.getCircleCount());
	   	
	   	System.out.println("Using queryForObject with query selection on one column for getting Circle name");
	   	System.out.println(circleJdbcImpl.getCircleNameForCircleId(1));
	   	
	   	
		System.out.println("-----------Using queryForObject and Row Mapper for getting Circle's-----------");
		Circle circle=circleJdbcImpl.getCircleForCircleId(1);
		System.out.println(circle.getCircleId()+" "+circle.getName());
		circle=circleJdbcImpl.getCircleForCircleId(2);
		System.out.println(circle.getCircleId()+" "+circle.getName());

	   	System.out.println("-----------Using Row Mapper to get List-----------");
	   	List<Circle> circles = circleJdbcImpl.getAllCirclesAsList();
	   	for (Circle circle1 : circles) {
			System.out.println(circle1.getCircleId()+" "+circle1.getName());
		}
	   	
	   	System.out.println("-----------Limiting  max records----------");
	   	circles = circleJdbcImpl.getLimitedCirclesAsList(3);
	   	for (Circle circle1 : circles) {
			System.out.println(circle1.getCircleId()+" "+circle1.getName());
		}
	   	
	}
}
