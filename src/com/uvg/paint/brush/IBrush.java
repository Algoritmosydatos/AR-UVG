package com.uvg.paint.brush;

import android.graphics.Canvas;
import android.graphics.Paint;

public interface IBrush {

	public Paint getPaint();
	public void setPaint(Paint paint);
	
	public void draw(Canvas canvas);
}
