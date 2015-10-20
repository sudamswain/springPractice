package com.pvn.model;



public class Circle{
	private String name;


	public String getName() {
		System.out.println("getName() executed");
		return name;
	}
	
	
	public void setName(String name) {
		System.out.println("setName() executed");
		this.name = name;
	}
	
	
	public String setFullName(String fn,String ln) 
	{
		if(fn.equalsIgnoreCase(ln))
			throw new RuntimeException();
		System.out.println("setFullName executed");
		return "Full name : "+fn+" "+ln;
	}
}
