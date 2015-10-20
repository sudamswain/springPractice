package com.pvn.event;

import org.springframework.context.ApplicationEvent;

import com.pvn.Shape;

public class DrawEvent extends ApplicationEvent 
{
	private static final long serialVersionUID = 1L;

	public DrawEvent(Object source) {
		super(source);
	}
	
	@Override
	public String toString() {
		return "Draw event occured";
	}
	
	public void displayShapeName()
	{
		System.out.println("Event called on "+((Shape)this.source).getName());
	}
	
}
