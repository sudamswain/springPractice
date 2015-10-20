package com.pvn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pvn.service.ShapeService;

public class AopMain 
{
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		ShapeService shape = context.getBean("shapeService",ShapeService.class);
		
		shape.getCircle().getName();
		shape.getCircle().setName("MyCircle");
		
		shape.getCircle().setFullName("Praveen","Lalasangi"); //For finally @AfterReturning
		//shape.getCircle().setFullName("Praveen","Praveen");   //For throwing exception @AfterThrowing
	}
}
