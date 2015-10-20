package com.pvn;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


public class Point implements InitializingBean,DisposableBean,BeanNameAware
{
	private int pointX;
	private int pointY;
	private String beanName;
	
	
	public int getPointX() {
		return pointX;
	}
	public void setPointX(int pointX) {
		this.pointX = pointX;
	}
	public int getPointY() {
		return pointY;
	}
	public void setPointY(int pointY) {
		this.pointY = pointY;
	}
	public String getBeanName(){
		return beanName;
	}
	@Override
	public void setBeanName(String beanName) {
		this.beanName=beanName;
	}
	
	/**
	 * Spring life cycle Call backs by implementing interfaces and 
	 * by overriding life cycle methods
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean's afterPropertiesSet for point "+getBeanName());
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean's destroy for point "+getBeanName());
	}
	
	
	/**
	 *  spring life cycle call backs by custom methods
	 */
	@PostConstruct
	public void initializePoint(){
		System.out.println("CUSTOM METHOD initializePoint for "+getBeanName());
	}
	@PreDestroy
	public void destroyPoint(){
		System.out.println("CUSTOM METHOD destroyPoint for "+getBeanName());
	}
	
}
