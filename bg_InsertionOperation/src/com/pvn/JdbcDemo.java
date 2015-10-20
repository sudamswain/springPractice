package com.pvn;



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
		CircleDaoJDBCImpl circleDaoJdbcImpl=ctx.getBean("circleDaoJDBCImpl", CircleDaoJDBCImpl.class);
		circleDaoJdbcImpl.createCircleTable();
		Circle circle=new Circle();
		circle.setCircleId(1);
		circle.setName("Circle"+1);
		int rowsAffected=circleDaoJdbcImpl.insertIntoCircle(circle);
		System.out.println(rowsAffected+" rows affected");
		
		rowsAffected=circleDaoJdbcImpl.insertIntoCircleByAutoGeneratedPK("Circle"+2);
		System.out.println(rowsAffected+" rows affected");
		
		
	}
}
