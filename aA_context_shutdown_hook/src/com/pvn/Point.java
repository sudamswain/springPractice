package com.pvn;

public class Point 
{
	private int pointX;
	private int pointY;
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
	
	public void pointInit()
	{
		System.out.println("Point Initializing");
	}
	
	public void pointDestroy()
	{
		System.out.println("Point Destroying");
	}
}
