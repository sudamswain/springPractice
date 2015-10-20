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
		
		//getters().getters()
		System.out.println("shape.getCircle().getName();");
		shape.getCircle().getName();
		
		System.out.println("shape.getTriangle().getName();");
		shape.getTriangle().getName();
		
		//getters.setters(arg)
		System.out.println("shape.getCircle().setName(\"Half Circle\");");
		shape.getCircle().setName("Half Circle");
		
		System.out.println("shape.getTriangle().setName(\"Isosceles triangle\");");
		shape.getTriangle().setName("Isosceles triangle");
	}
}
