package com.uvg.mapa.db.model;

public class Building{
	
	private double lr_latitude, lr_longitude, ul_latitude, ul_longitude;
	
	private int id;
	
	private String name;
	
	private Room[] rooms;

	public Building(int id, String name, double lr_latitude, double lr_longitude, 
			double ul_latitude, double ul_longitude){
		
		this.id = id;
		
		this.name = name;
		
		this.lr_latitude = lr_latitude;
		this.lr_longitude = lr_longitude;
		this.ul_latitude = ul_latitude;
		this.ul_longitude = ul_longitude;
		
		rooms = null;
		
	}
	
	public boolean checkCoordinates(double latitude, double longitude){
		if((latitude <= lr_latitude && latitude >= ul_latitude) && 
				(longitude <= lr_longitude && longitude >= ul_longitude))
			return true;
		else
			return false;
		
	}
	
	public double getLr_latitude() {
		return lr_latitude;
	}

	public void setLr_latitude(double lr_latitude) {
		this.lr_latitude = lr_latitude;
	}

	public double getLr_longitude() {
		return lr_longitude;
	}

	public void setLr_longitude(double lr_longitude) {
		this.lr_longitude = lr_longitude;
	}

	public double getUl_latitude() {
		return ul_latitude;
	}

	public void setUl_latitude(double ul_latitude) {
		this.ul_latitude = ul_latitude;
	}

	public double getUl_longitude() {
		return ul_longitude;
	}

	public void setUl_longitude(double ul_longitude) {
		this.ul_longitude = ul_longitude;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Room[] getRooms() {
		return rooms;
	}

	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}
}