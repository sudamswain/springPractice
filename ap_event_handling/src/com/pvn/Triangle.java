package com.pvn;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import com.pvn.event.DrawEvent;

public class Triangle implements Shape,ApplicationContextAware,ApplicationEventPublisherAware
{
	private String name;
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private ApplicationContext context;
	private ApplicationEventPublisher publisher;
	public Point getPointA() {
		return pointA;
	}
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}
	public Point getPointB() {
		return pointB;
	}
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}
	public Point getPointC() {
		return pointC;
	}
	public void setPointC(Point pointC) {
		this.pointC = pointC;
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
		System.out.println(context.getMessage("t.pointA", new Object[]{getPointA().getPointX(),getPointA().getPointY()}, "Point : (pointsX,pointY)", Locale.US));
		System.out.println(context.getMessage("t.pointB", new Object[]{getPointB().getPointX(),getPointB().getPointY()}, "Point : (pointsX,pointY)", Locale.CANADA));
		System.out.println(context.getMessage("t.pointC", new Object[]{getPointC().getPointX(),getPointC().getPointY()}, "Point : (pointsX,pointY)", Locale.GERMANY));
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
