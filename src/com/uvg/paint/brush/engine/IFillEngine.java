package com.uvg.paint.brush.engine;

public interface IFillEngine {

	public int getAmountNeeded();
	
	public double getXDelta();
	
	public double getYDelta();
	
	public void reset(int figureSize);
	
	public void compute(double x, double y);
	
	public double getLastX();
	
	public void setLastX(double lastX);
	
	public double getLastY();
	
	public void setLastY(double lastY);
	
	public int getFigureSize();
	
	public void setFigureSize(int figureSize);
}
