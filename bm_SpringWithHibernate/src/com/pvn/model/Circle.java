package com.pvn.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Circle 
{
	@Id
	private int circleId;
	private String name;
	public int getCircleId() {
		return circleId;
	}
	public void setCircleId(int circleId) {
		this.circleId = circleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
