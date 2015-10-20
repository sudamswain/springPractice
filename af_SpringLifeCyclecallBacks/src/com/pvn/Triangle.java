package com.pvn;

import java.util.Collection;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


public class Triangle implements InitializingBean,DisposableBean
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
			System.out.println("point= ("+point.getPointX()+","+point.getPointY()+")");
		}
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing  init method is called for triangle");
		
	}
	@Override
	public void destroy() throws Exception {
		
		System.out.println("DisposableBean   destroy method is   called for triangle");
		
		
	}

}
