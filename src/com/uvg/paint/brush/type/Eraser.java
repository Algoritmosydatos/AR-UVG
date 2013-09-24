package com.uvg.paint.brush.type;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.uvg.paint.brush.Brush;

public class Eraser extends Brush{
	
	private int size;

	public Eraser(double x, double y, Paint paint, int size) {
		super(x, y, paint);
		// TODO Auto-generated constructor stub
		getPaint().setARGB(255, 0, 0, 0);
		this.size = size;
	}

	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		Rect rect = new Rect((int)getX(), (int)getY(), (int)getX() + size, (int)getY() + size);
		canvas.drawRect(rect, getPaint());
	}
	
}
