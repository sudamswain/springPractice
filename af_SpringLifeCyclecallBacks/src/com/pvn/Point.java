package com.pvn;

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
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("after Intializing point "+getBeanName());
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("before Destroying point "+getBeanName());
	}
	@Override
	public void setBeanName(String beanName) {
		this.beanName=beanName;
	}
	public String getBeanName(){
		return beanName;
	}
	
}
