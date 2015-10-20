package com.pvn;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pvn.dao.jdbc.impl.CircleDaoJDBCImpl;
import com.pvn.model.Circle;

public class JdbcDemo 
{
	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		CircleDaoJDBCImpl circleJdbcImpl=ctx.getBean("circleDaoJDBCImpl", CircleDaoJDBCImpl.class);
	   	Circle circle= circleJdbcImpl.getCircle(2);
	   	System.out.println(circle.getName());
	}
}
