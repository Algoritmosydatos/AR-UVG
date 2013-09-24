package com.uvg.paint.brush.type;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import com.uvg.paint.brush.Brush;
import com.uvg.paint.brush.BrushManager;

public class Line extends Brush{
	
	private double previousX, previousY;
	private boolean dead;

	public Line(double x, double y, double previousX, double previousY, Paint paint) {
		super(x, y, paint);
		// TODO Auto-generated constructor stub
		this.previousX = previousX;
		this.previousY = previousY;
		
		if(BrushManager.UP_FLAG>0){
			BrushManager.UP_FLAG--;
			dead = true;
		}else{
			dead = false;
		}
	}
	
	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		if(!dead)
			canvas.drawLine((float)getX(), (float)getY(), (float)previousX, (float)previousY, getPaint());
	}
	
  	public double getpreviousX(){
  		return previousX;
  	}
	public void setpreviousX(double previousX){
		this.previousX = previousX;
	}

	public double getpreviousY(){
		return previousY;
	}
	public void setpreviousY(double previousY){
		this.previousY = previousY;
	}

}
