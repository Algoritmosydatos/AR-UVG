package com.uvg.paint.brush.engine;

public class FillEngine implements IFillEngine{

	int amountNeeded, figureSize;
	double xDelta, yDelta;
	double lastX, lastY;
	
	public FillEngine(int figureSize){
		this.figureSize = figureSize;
		amountNeeded = 0;
		xDelta = 0;
		yDelta = 0;
		lastX = 0;
		lastY = 0;
	}
	
	@Override
	public int getAmountNeeded() {
		// TODO Auto-generated method stub
		return amountNeeded;
	}

	@Override
	public double getXDelta() {
		// TODO Auto-generated method stub
		return xDelta;
	}

	@Override
	public double getYDelta() {
		// TODO Auto-generated method stub
		return yDelta;
	}

	@Override
	public void compute(double x, double y) {
		// TODO Auto-generated method stub
		if(lastX!=0 || lastY!=0){
			xDelta = (x - lastX);
			yDelta = (y - lastY);
			amountNeeded = (int)Math.floor((xDelta*xDelta + yDelta*yDelta)/figureSize);
			xDelta = xDelta/amountNeeded;
			yDelta = yDelta/amountNeeded;
		}
		lastX = x;
		lastY = y;
	}

	@Override
	public void reset(int figureSize) {
		// TODO Auto-generated method stub
		this.figureSize = figureSize;
		amountNeeded = 0;
		xDelta = 0;
		yDelta = 0;
		lastX = 0;
		lastY = 0;
	}

	@Override
	public double getLastX() {
		// TODO Auto-generated method stub
		return lastX;
	}

	@Override
	public void setLastX(double lastX) {
		// TODO Auto-generated method stub
		this.lastX = lastX;
	}

	@Override
	public double getLastY() {
		// TODO Auto-generated method stub
		return lastY;
	}

	@Override
	public void setLastY(double lastY) {
		// TODO Auto-generated method stub
		this.lastY = lastY;
	}

	@Override
	public int getFigureSize() {
		// TODO Auto-generated method stub
		return figureSize;
	}

	@Override
	public void setFigureSize(int figureSize) {
		// TODO Auto-generated method stub
		this.figureSize = figureSize;
	}

}
