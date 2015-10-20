package com.pvn;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Drawing 
{
	public static void main(String[] args) {
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		System.out.println("------- In Drawing class ----------");
		Triangle triangle=(Triangle)context.getBean("triangle");
		triangle.draw();
	}
}
