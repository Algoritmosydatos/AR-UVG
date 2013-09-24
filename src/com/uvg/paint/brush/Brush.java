package com.uvg.paint.brush;


import android.graphics.Paint;

public abstract class Brush implements IBrush, IPosition{
	
	private Paint paint;
	private double x, y;
	
	public Brush(double x, double y, Paint paint){
		this.x = x;
		this.y = y;
		this.paint = paint;
	}

	public Paint getPaint(){
		return paint;
	}
	public void setPaint(Paint paint){
		this.paint = paint;
	}
	
  	public double getX(){
  		return x;
  	}
	public void setX(double x){
		this.x = x;
	}

	public double getY(){
		return y;
	}
	public void setY(double y){
		this.y = y;
	}
	
}
