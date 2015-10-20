package com.pvn.model;

public class Circle 
{
	private int circleId;
	private String name;

	public Circle() {}
	public Circle(int circleId, String name) {
		System.out.println("Const");
		this.circleId = circleId;
		this.name = name;
	}
	public int getCircleId() {
		System.out.println("setId");
		return circleId;
	}
	public void setCircleId(int circleId) {
		this.circleId = circleId;
	}
	public String getName() {
		System.out.println("setName");
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() 
	{
		return this.circleId+" "+this.name;
	}
}
