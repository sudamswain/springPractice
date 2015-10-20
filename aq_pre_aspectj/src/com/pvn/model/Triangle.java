package com.pvn.model;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class Triangle implements ApplicationContextAware {
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
		this.name = context.getMessage("triangle", null, "Default Triangle Message", null);
	}
}
