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
		System.out.println("---------Circle-------");
		System.out.println(shape.getCircle().getArea());
		System.out.println(shape.getCircle().getName());
		System.out.println("---------Triangle-------");
		System.out.println(shape.getTriangle().getName());
		System.out.println(shape.getTriangle().getArea());
	}
}
