package com.pvn;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements ApplicationContextAware
{
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private ApplicationContext context;
	
	public Point getPointA() {
		return pointA;
	}
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}
	public Point getPointB() {
		return pointB;
	}
	public void setPointB(Point pointB) {
		System.out.println("Setting Point B");
		this.pointB = pointB;
	}
	public Point getPointC() {
		return pointC;
	}
	public void setPointC(Point pointC) {
		System.out.println("Setting Point C");
		this.pointC = pointC;
	}
	
	public void draw()
	{
		System.out.println("Point A = ("+getPointA().getPointX()+","+getPointA().getPointY()+")");
		System.out.println("Point B = ("+getPointB().getPointX()+","+getPointB().getPointY()+")");
		System.out.println("Point C = ("+getPointC().getPointX()+","+getPointC().getPointY()+")");
	}
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context=context;
		this.pointC=((Point)context.getBean("pointC"));
	}
}
