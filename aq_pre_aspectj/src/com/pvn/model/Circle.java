package com.pvn.model;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class Circle implements ApplicationContextAware
{
	private String name;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setApplicationContext(ApplicationContext context)
	throws BeansException {
		this.name = context.getMessage("circle", null, "Default Circle Message", null);
	}
}
