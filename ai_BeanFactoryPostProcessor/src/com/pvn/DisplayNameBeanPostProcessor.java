package com.pvn;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class DisplayNameBeanPostProcessor implements BeanPostProcessor 
{

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) 
	throws BeansException {
		if(bean instanceof Point)
		{
			System.out.println("After point = ("+((Point)bean).getPointX()+","+((Point)bean).getPointY()+")");
		}
		System.out.println("After Intialization of "+beanName);
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) 
	throws BeansException {
		if(bean instanceof Point)
		{
			System.out.println("Before Point = ("+((Point)bean).getPointX()+","+((Point)bean).getPointY()+")");
		}
		System.out.println("Before Intialization of "+beanName);
		return bean;
	}

}
