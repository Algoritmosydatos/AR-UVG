package com.uvg.mapa.gui;

import android.graphics.Canvas;
import android.graphics.Paint;

public class PersonalIdentifier extends Identifier{
	
	// the draw method which draws the corresponding frame
	public void draw(Canvas canvas) {
		// where to draw the sprite
		canvas.drawCircle((float)getLatitude(), (float)getLongitude(), getRadius(), getPaint());
	}
	
	public void update(){
		updatePaint();
	}
}