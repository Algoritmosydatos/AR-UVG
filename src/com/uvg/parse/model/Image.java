package com.uvg.parse.model;

import java.sql.Date;

import com.parse.ParseFile;
import com.parse.ParseUser;

public class Image extends Model{

	public static final String IMAGE_TOKEN = "image";
	
	public static final String TAG_TOKEN = "tag";
	public static final String WIDTH_TOKEN = "width";
	public static final String HEIGHT_TOKEN = "height";
	public static final String PICTURE_FILE_TOKEN = "picture_file";
	
	private String tag;
	private double width, height;
	private byte[] picture;
	private ParseFile pictureFile;
	
	public Image(ParseUser owner, String id, double positionX, double positionY, Date updatedAt, Date createdAt,
			String tag, double width, double height, byte[] picture, ParseFile pictureFile){
		super(owner, id, positionX, positionY, updatedAt, createdAt);	
		this.tag = tag;
		this.width = width;
		this.height = height;
		this.picture = picture;
		this.pictureFile = pictureFile;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public ParseFile getPictureFile() {
		return pictureFile;
	}

	public void setPictureFile(ParseFile pictureFile) {
		this.pictureFile = pictureFile;
	}
}
