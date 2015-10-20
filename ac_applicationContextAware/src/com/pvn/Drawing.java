package com.pvn;

import org.springframework.beans.factory.BeanIsAbstractException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Drawing 
{
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		Triangle triangle=(Triangle)context.getBean("triangle");
		triangle.draw();
		
		try
		{
			Point point=(Point) context.getBean("XatZero");
			System.out.println(point.getPointX()+","+point.getPointY());
		}
		catch(BeanIsAbstractException e)
		{
			System.out.println("BeanIsAbstractException \n cannot create a bean having abstarct=true ");
		}
	}
}
