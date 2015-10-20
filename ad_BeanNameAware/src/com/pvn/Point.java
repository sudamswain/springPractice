package com.pvn;

import org.springframework.beans.factory.BeanNameAware;

public class Point implements BeanNameAware
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
	public void setBeanName(String beanName) {
		this.beanName=beanName;
	}
	public String getBeanName() {
		return beanName;
	}
}
