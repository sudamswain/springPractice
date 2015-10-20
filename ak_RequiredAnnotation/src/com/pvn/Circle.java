package com.pvn;

import org.springframework.beans.factory.annotation.Required;

public class Circle implements Shape
{
	private Point center;

	public Point getCenter() {
		return center;
	}
	
	/**
	 * 
	 * @param center
	 * Spring container will fail to load if center dependency is not defined in spring XML
	 * 
	 */
	@Required
	public void setCenter(Point center) {
		this.center = center;
	}
	
	@Override
	public void draw()
	{
		System.out.println("Circle with center : ("+center.getPointX()+","+center.getPointY()+")");
	}
}
