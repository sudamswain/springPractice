package com.pvn.model;

import com.pvn.aspect.MakeAfter;
import com.pvn.aspect.MakeAfterThrowing;

public class Circle{
	private String name;

	@MakeAfter
	public String getName() {
		System.out.println("getName() executed");
		return name;
	}
	
	
	public void setName(String name) {
		System.out.println("setName() executed");
		this.name = name;
	}
	
	@MakeAfterThrowing
	public String setFullName(String fn,String ln) 
	{
		if(fn.equalsIgnoreCase(ln))
			throw new RuntimeException();
		System.out.println("setFullName executed");
		return "Full name : "+fn+" "+ln;
	}
}
