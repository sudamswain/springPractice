package com.pvn;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import com.pvn.event.DrawEvent;

public class Circle implements Shape,ApplicationContextAware,ApplicationEventPublisherAware
{
	private String name;
	private Point center;
	private ApplicationContext context;
	private ApplicationEventPublisher publisher;

	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void draw()
	{
		DrawEvent event=new DrawEvent(this);
		publisher.publishEvent(event);
		System.out.println(context.getMessage("circle", new Object[]{center.getPointX(),center.getPointY()}, "drawingMessages", null));
	}
	
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context=context;
	}
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher=publisher;
	}
}
