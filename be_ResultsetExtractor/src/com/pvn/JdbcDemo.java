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
	   	System.out.println("Total circles count is : "+circleJdbcImpl.getCircleCount());

		System.out.println("-----------Using Result set extractor-----------");
	   	List<Circle> circles = circleJdbcImpl.getAllCirclesAsListReseultSetExtractor();
	   	for (Circle circle : circles) {
			System.out.println(circle.getCircleId()+" "+circle.getName());
		}
	}
}
