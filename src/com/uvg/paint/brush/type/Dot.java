package com.uvg.paint.brush.type;

import com.uvg.paint.brush.Brush;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Dot extends Brush{
	
	private static final String TAG = Dot.class.getSimpleName();
	
	double radius;
	
	public Dot(double x, double y, double radius, Paint paint) {
		super(x,y,paint);
		this.radius = radius;
	}
	
	public void draw(Canvas canvas) {
		//canvas.drawCircle((float)getX(), (float)getY(), (float)getSize(), getPaint());
		canvas.drawPoint((float)getX(), (float)getY(), getPaint());
	}

	public double getRadius() {
		// TODO Auto-generated method stub
		return radius;
	}

	public void setRadius(double radius) {
		// TODO Auto-generated method stub
		this.radius = radius;
	}
}