package com.pvn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pvn.dao.CircleHibernateImpl;

public class MainClass 
{
	public static void main(String[] args) 
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		CircleHibernateImpl circleHibernateImpl=context.getBean("circleHibernateImpl", CircleHibernateImpl.class);
		System.out.println(circleHibernateImpl.getCirclesCount());
	}
}
