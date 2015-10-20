package com.pvn.model;

public class Circle
{
	private String name;
	private int area;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("setter name");
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
}
