package com.uvg.paint;

import java.util.ArrayList;

import com.uvg.paint.brush.Brush;
import com.uvg.paint.brush.BrushManager;
import com.uvg.paint.brush.engine.FillEngine;
import com.uvg.paint.brush.type.BrushFactory;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainPanel extends SurfaceView implements SurfaceHolder.Callback{
	
	private static final String TAG = MainPanel.class.getSimpleName();
	
	private MainThread thread;
	
	private ArrayList<Brush> brush;
	
	private FillEngine fillIt;

	private BrushManager manager;

	int iter = 0;
	
	public MainPanel(Context context, AttributeSet attr){
		super(context, attr);
		
		// adding the callback (this) to the surface holder to intercept events
		getHolder().addCallback(this);

		// make the GamePanel focusable so it can handle events
		setFocusable(true);
		
		brush = new ArrayList<Brush>();
		manager = new BrushManager();
		fillIt = new FillEngine(manager.getSize());
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub		
	}

	public void surfaceCreated(SurfaceHolder holder) {
		// create the game loop thread
		thread = new MainThread(getHolder(), this);
		
		// at this point the surface is created and
		// we can safely start the game loop
		thread.setRunning(true);
		thread.start();
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		Log.d(TAG, "Surface is being destroyed");
		// tell the thread to shut down and wait for it to finish
		// this is a clean shutdown
		boolean retry = true;
		while (retry) {
			try {
				thread.join();
				retry = false;
			} catch (InterruptedException e) {
				// try again shutting down the thread
			}
		}
		Log.d(TAG, "Thread was shut down cleanly");
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if(event.getAction() == MotionEvent.ACTION_UP){
			BrushManager.UP_FLAG = 3;
		}
		
		if(fillIt.getLastX()!=0 || fillIt.getLastY()!=0){
			brush.add(BrushFactory.create(manager.getType(), event, fillIt, manager.getSize(), manager.getPaint()));
		}
		fillIt.compute(event.getX(), event.getY());
		return true;
	}
	
	public void render(Canvas canvas){
		canvas.drawColor(Color.WHITE);
		for(int i = 0; i < brush.size(); i++){
			brush.get(i).draw(canvas);
		}
	}
	
	public void update() {
	}
	
	public BrushManager getBrushManager(){
		return manager;
	}
}
