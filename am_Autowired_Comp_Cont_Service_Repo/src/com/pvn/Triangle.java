package com.pvn;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class Triangle implements Shape
{
	private Point pointA;
	private Point pointB;
	private Point pointC;
	public Point getPointA() {
		return pointA;
	}
	@Resource	
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}
	public Point getPointB() {
		return pointB;
	}
	@Resource	
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}
	public Point getPointC() {
		return pointC;
	}
	@Autowired
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
	
	@Override
	public void draw()
	{
		System.out.println("Point A = ("+getPointA().getPointX()+","+getPointA().getPointY()+")");
		System.out.println("Point B = ("+getPointB().getPointX()+","+getPointB().getPointY()+")");
		System.out.println("Point C = ("+getPointC().getPointX()+","+getPointC().getPointY()+")");
	}
}
