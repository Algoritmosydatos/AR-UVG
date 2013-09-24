package com.uvg.paint.brush;

import android.graphics.Paint;

public class BrushManager {

	//FLAGS
	public static int UP_FLAG = 3;
	
	//TYPE CONSTANTES
	public static final int LINE = 0, DOT = 1, ERASER = 2;

	//
	private int type, size;
	private Paint paint;
	
	public BrushManager(int type, int size, Paint paint){
		this.type = type;
		this.size = size;
		this.paint = paint;
	}
	
	public BrushManager(){
		type = LINE;
		size = 5;
		paint = new Paint();
		paint.setARGB(255, 0, 0, 255);
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Paint getPaint() {
		return paint;
	}

	public void setPaint(Paint paint) {
		this.paint = paint;
	}	
}
