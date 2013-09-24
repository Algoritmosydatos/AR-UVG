package com.uvg.parse.model;

import java.sql.Date;

import com.parse.ParseUser;

public class PostIt extends Model{
	
	public static final String POSTIT_TOKEN = "postit";
	
	public static final String TITLE_TOKEN = "title";
	public static final String CONTENT_TOKEN = "content";
	
	private String title, content;
	
	public PostIt(ParseUser owner, String id, double positionX, double positionY, Date updatedAt, Date createdAt,
			String title, String content){
		super(owner, id, positionX, positionY, updatedAt, createdAt);
		this.title = title;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
