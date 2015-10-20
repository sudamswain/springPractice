package com.pvn.model;

public class Circle 
{
	private int circleId;
	private String name;
	
	public Circle(int circle_id, String name) {
		super();
		this.circleId = circle_id;
		this.name = name;
	}
	
	public int getCircle_id() {
		return circleId;
	}
	public void setCircle_id(int circle_id) {
		this.circleId = circle_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
