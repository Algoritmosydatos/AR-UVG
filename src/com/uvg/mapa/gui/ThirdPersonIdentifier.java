package com.uvg.mapa.gui;

import android.graphics.Canvas;

public class ThirdPersonIdentifier extends Identifier{

	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		canvas.drawCircle((float)getLatitude(), (float)getLongitude(), getRadius(), getPaint());
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
