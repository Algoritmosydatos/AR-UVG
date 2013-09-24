package com.uvg.parse.model;

import java.sql.Date;

import com.parse.ParseUser;

public abstract class Model{
	
	public static final String OWNER_TOKEN = "owner";
	public static final String POSITIONX_TOKEN = "position_x";
	public static final String POSITIONY_TOKEN = "position_y";
	
	private ParseUser owner;
	
	private String id;
	
	private double positionX, positionY;
	
	private Date updatedAt,createdAt;
	
	public Model(ParseUser owner, String id, double positionX, double positionY, Date updatedAt, Date createdAt){

		if(owner != null)
			this.owner = owner;
		else
			this.owner = ParseUser.getCurrentUser();
		
		this.id = id;
		this.positionX = positionX;
		this.positionY = positionY;
		this.updatedAt = updatedAt;
		this.createdAt = createdAt;
	}

	public ParseUser getOwner() {
		return owner;
	}

	public void setOwner(ParseUser owner) {
		this.owner = owner;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getPositionX() {
		return positionX;
	}

	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}

	public double getPositionY() {
		return positionY;
	}

	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
