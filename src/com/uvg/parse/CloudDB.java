package com.uvg.parse;

import com.uvg.parse.model.Image;
import com.uvg.parse.model.PostIt;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class CloudDB {
	
	/*
	public void uploadImage(Image image, SaveCallback callback){
		ParseFile file = new ParseFile(String.valueOf(image.getId())+".png", image.getPicture());
		ParseObject imageObj = new ParseObject(Image.IMAGE_TOKEN);
		imageObj.put(Image.OWNER_TOKEN, image.getOwner());
		imageObj.put(Image.TAG_TOKEN, image.getTag());
		imageObj.put(Image.WIDTH_TOKEN, image.getWidth());
		imageObj.put(Image.HEIGHT_TOKEN, image.getHeight());
		imageObj.put(Image.POSITIONX_TOKEN, image.getPositionX());
		imageObj.put(Image.POSITIONY_TOKEN, image.getPositionY());
		imageObj.put(Image.PICTURE_FILE_TOKEN, file);
		
		imageObj.saveEventually(callback);
	}
	
	public void uploadImage(Image image){
		ParseFile file = new ParseFile(String.valueOf(image.getId())+".png", image.getPicture());
		ParseObject imageObj = new ParseObject(Image.IMAGE_TOKEN);
		imageObj.put(Image.OWNER_TOKEN, image.getOwner());
		imageObj.put(Image.TAG_TOKEN, image.getTag());
		imageObj.put(Image.WIDTH_TOKEN, image.getWidth());
		imageObj.put(Image.HEIGHT_TOKEN, image.getHeight());
		imageObj.put(Image.POSITIONX_TOKEN, image.getPositionX());
		imageObj.put(Image.POSITIONY_TOKEN, image.getPositionY());
		imageObj.put(Image.PICTURE_FILE_TOKEN, file);
		
		imageObj.saveEventually();
	}*/
	
	public void uploadPostIt(PostIt postIt, SaveCallback callback){
		ParseObject postItObj = new ParseObject(PostIt.POSTIT_TOKEN);
		postItObj.put(PostIt.OWNER_TOKEN, postIt.getOwner());
		postItObj.put(PostIt.TITLE_TOKEN, postIt.getTitle());
		postItObj.put(PostIt.CONTENT_TOKEN, postIt.getContent());
		postItObj.put(PostIt.POSITIONX_TOKEN, postIt.getPositionX());
		postItObj.put(PostIt.POSITIONY_TOKEN, postIt.getPositionY());
		
		postItObj.saveEventually(callback);
	}
	
	public void uploadPostIt(PostIt postIt){
		ParseObject postItObj = new ParseObject(PostIt.POSTIT_TOKEN);
		postItObj.put(PostIt.OWNER_TOKEN, postIt.getOwner());
		postItObj.put(PostIt.TITLE_TOKEN, postIt.getTitle());
		postItObj.put(PostIt.CONTENT_TOKEN, postIt.getContent());
		postItObj.put(PostIt.POSITIONX_TOKEN, postIt.getPositionX());
		postItObj.put(PostIt.POSITIONY_TOKEN, postIt.getPositionY());
		
		postItObj.saveEventually();
	}
	
	
	
	
}
