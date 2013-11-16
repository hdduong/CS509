package model;

import java.awt.Graphics;

public class Graph {
	
	final int NUM_VALUES_IN_X_AXIS = 8;
	final int NUM_VALUES_IN_Y_AXIS = 6;
	
	DataSet ds;
	 
	double panelWidth;
	double panelHeight;
	 
	double  maxX = 0.0;	// default maximum range of X axis value labels
	double  minX = 0.0; 
	double  maxY = 0.0;	// default maximum range of Y axis value labels
	double  minY = 0.0; 
	
	int stepXLabel = 0;
	int stepYLabel = 0;

	boolean enableHorizontalLine = true;
	boolean enableXYLabels = true;
	
	public Graph(DataSet dataset) {
		this.ds = dataset;
	}

	
	public boolean hasHorizontalLine() { return enableHorizontalLine;}
	
	public void setHorizontalLine(boolean enable) { enableHorizontalLine = enable;}
	
	public boolean hasXYLables() {return enableXYLabels;}
	
	public void setXYLabels(boolean enable) {enableXYLabels = enable;}

	public double getMaxX() { return maxX; }

	public double getMaxY() { return maxY; }

	public double getMinX() { return minX; }
	
	public double getMinY() { return minY; }
	
	public void calculateMaxMin() { }
	
	public void draw(Graphics g) { }
	

	
	public void setStepXLabel () {		
		if ( (maxX - minX)> NUM_VALUES_IN_X_AXIS)
			stepXLabel = (int) (maxX - minX) / NUM_VALUES_IN_X_AXIS;
		else 
			stepXLabel = 1; 
	}
	
	public void setStepYLabel () { 
		if ( (maxY - minY)> NUM_VALUES_IN_Y_AXIS)
			stepYLabel = (int) (maxY - minY) / NUM_VALUES_IN_Y_AXIS;
		else 
			stepYLabel = 1; 
	}
	
	public int getStepXLabel () { return stepXLabel; }
	
	public int getStepYLabel () { return stepYLabel; }
		
}
