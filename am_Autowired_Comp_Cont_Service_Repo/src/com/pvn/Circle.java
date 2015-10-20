package com.pvn;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class Circle implements Shape
{
	
	private Point center;

	public Point getCenter() {
		return center;
	}
	@Autowired
//	@Resource		/** similar to @Autowire byName */
	@Qualifier("circleRelated")
	public void setCenter(Point center) {
		this.center = center;
	}
	
	@Override
	public void draw()
	{
		System.out.println("Circle with center : ("+center.getPointX()+","+center.getPointY()+")");
	}
}
