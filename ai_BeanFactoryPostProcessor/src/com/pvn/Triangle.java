package com.pvn;

import java.util.Collection;

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
			System.out.println("point= ("+point.getPointX()+","+point.getPointY()+")");
		}
	}
}
