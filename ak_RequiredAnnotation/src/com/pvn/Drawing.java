package com.pvn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Drawing 
{
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		/*Triangle triangle=(Triangle)context.getBean("triangle");
		triangle.draw();*/
		/*Circle circle=(Circle)context.getBean("circle");
		circle.draw();*/
		
		Shape shape=(Shape)context.getBean("triangle");
		shape.draw();
		
		((Shape)context.getBean("circle")).draw();
	}
}
