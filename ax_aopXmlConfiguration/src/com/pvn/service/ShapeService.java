package com.pvn.service;


import com.pvn.model.Circle;
import com.pvn.model.Triangle;

//@Service
public class ShapeService {
	private Circle circle;
	private Triangle triangle;
	
	public Circle getCircle() {
		return circle;
	}
	//@Autowired
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public Triangle getTriangle() {
		return triangle;
	}
	//@Autowired
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
}
