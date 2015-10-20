package com.pvn;

import java.util.Collection;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle
{
	private Collection<Point> points;
	
	public Collection<Point> getPoints() {
		return points;
	}
	public void setPoints(Collection<Point> points) {
		this.points = points;
	}

	public void draw()
	{
		for(Point point:points)
		{
			System.out.println(point.getBeanName()+"= ("+point.getPointX()+","+point.getPointY()+")");
		}
	}

}
