package com.pvn;

//import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Drawing 
{
	public static void main(String[] args) {
		System.out.println("sudam testing");
		System.out.println("sudam testing2");
//		AbstractApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		Triangle triangle=(Triangle)context.getBean("triangle");
		triangle.draw();
		context.registerShutdownHook();
//		context.close();
	}
}
