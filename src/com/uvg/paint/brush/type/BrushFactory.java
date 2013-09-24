package com.uvg.paint.brush.type;

import android.graphics.Paint;
import android.view.MotionEvent;

import com.uvg.paint.brush.Brush;
import com.uvg.paint.brush.BrushManager;
import com.uvg.paint.brush.engine.FillEngine;

public class BrushFactory {
	
	public static Brush create(int object_id, MotionEvent event, FillEngine fillIt, int radius, Paint paint){
		switch(object_id){
		case BrushManager.LINE:
			return new Line(event.getX(), event.getY(), fillIt.getLastX(), fillIt.getLastY(), paint);
		case BrushManager.DOT:	
			return new Dot(event.getX(), event.getY(), radius, paint);
		}
		return null;
	}
}
