package com.pvn.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.pvn.Shape;

public class MyEventListener implements ApplicationListener
{

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if(!(event instanceof ContextRefreshedEvent))
		{
			System.out.println(event.toString());
			System.out.println("Event called on "+((Shape)event.getSource()).getName());
		}
	}

}
