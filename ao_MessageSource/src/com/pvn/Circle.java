package com.pvn;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Circle implements Shape,ApplicationContextAware
{
	private Point center;
	private ApplicationContext context;

	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	
	@Override
	public void draw()
	{
		System.out.println(context.getMessage("circle", new Object[]{center.getPointX(),center.getPointY()}, "drawingMessages", null));
	}
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context=context;
	}
}
