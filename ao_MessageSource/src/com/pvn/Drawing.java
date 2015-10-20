package com.pvn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Drawing 
{
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		Shape shape=(Shape)context.getBean("triangle");
		shape.draw();
		shape=(Shape)context.getBean("circle");
		shape.draw();
	}
}
