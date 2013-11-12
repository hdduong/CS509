package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D.Double;

public class CartesianPlot extends Graph{

	double panelWidth;
	double panelHeight;
	final double PERCENT_MARGIN = 0.05; 	// margin for Catersian plot
	
	boolean enableTrendLine = true;
	boolean enableEquation = true;
	
	TrendLine trendLine;
		
	public CartesianPlot(DataSet dataset, double pnlWidth, double pnlHeight) {
		super(dataset);
		
		this.panelWidth = pnlWidth;
		this.panelHeight = pnlHeight;
		
		trendLine = new TrendLine(dataset); 	
	}
	
	public double getPanelWidth() {return panelWidth; }
	public double getPanelHeight() {return panelHeight; }
	
	public boolean hasTrendLine() { return enableTrendLine;}
	public boolean hasEquation() { return enableEquation;}
	
	public void setEquaiton(boolean enable) { enableEquation = false; }
	
	public void setTrendLine(boolean enable) {
		if (enable) { enableTrendLine = enable;}
		else {
			enableTrendLine = enable;
			enableEquation = enable;
		}
	}
	
	public void calculateMaxMin() {
		
		// remember to set default value first
		maxX = 0.5;	
		minX = -0.5; 
		maxY = 0.5;
		minY = -0.5; 
		
		
		for (int i = 0; i < ds.count();i ++ ) {
			if (maxX < ds.getDataPointAt(i).getX() ) {
				maxX = ds.getDataPointAt(i).getX();			//align border right
			}
			
			if (maxY < ds.getDataPointAt(i).getY() ) {
				maxY = ds.getDataPointAt(i).getY();			//align border top
			}
			
			if (minX > ds.getDataPointAt(i).getX() ) {
				minX = ds.getDataPointAt(i).getX();			//align border left
			}
			
			if (minY > ds.getDataPointAt(i).getY() ) {
				minY = ds.getDataPointAt(i).getY();			//align border bottom
			}
		}
		
		if (maxX >= 0) { maxX += maxX*PERCENT_MARGIN; } else { maxX -=  maxX*PERCENT_MARGIN; }
		if (maxY >= 0) { maxY += maxY*PERCENT_MARGIN; } else { maxY -=  maxY*PERCENT_MARGIN; }
		if (minX >= 0) { minX -= minX*PERCENT_MARGIN; } else { minX +=  minX*PERCENT_MARGIN; }
		if (minY >= 0) { minY -= minY*PERCENT_MARGIN; } else { minY +=  minY*PERCENT_MARGIN; }
		
	}
	
	public void draw(Graphics g) {
		
		Graphics2D g2 = (Graphics2D)g;
		
		// Those three methods below MUST stick with each other
		calculateMaxMin();
		setStepXLabel();
		setStepYLabel();
		
		g2.translate(getPanelWidth()/2.0, getPanelHeight()/2.0);
		g2.scale( getPanelWidth() / ( getMaxX() - getMinX() ), - getPanelHeight() / ( getMaxY() - getMinY() ) );
		g2.translate(-(getMaxX() + getMinX()) /2.0, -(getMaxY() + getMinY()) /2.0);
		
		AffineTransform g2AfterFixCoor = g2.getTransform();
		
		// recalculate pixel size in new coordination
		double pixelWidth = (getMaxX() - getMinX()) / getPanelWidth();
		double pixelHeight = (getMaxY() - getMinY()) / getPanelHeight();
		
		g2.setStroke(new BasicStroke(0)) ;		// thickness of stroke is smallest
		
		g2.setColor(Color.BLACK);				// draw Axis
		g2.draw(new Line2D.Double(getMinX(), 0, getMaxX(), 0) ); 
		g2.draw(new Line2D.Double(0, getMinY(),0, getMaxY()));
		
		 /* Draw an anchor for axis */
        // X axis
        g2.draw( new Line2D.Double(getMaxX(),0,getMaxX()-5*pixelWidth,5*pixelHeight));
        g2.draw( new Line2D.Double(getMaxX()-5*pixelWidth,5*pixelHeight,getMaxX()-5*pixelWidth,-5*pixelHeight));
        g2.draw( new Line2D.Double(getMaxX()-5*pixelWidth,-5*pixelHeight,getMaxX(),0));
        
        // Y axis
        g2.draw( new Line2D.Double(0,getMaxY(),-5*pixelWidth,getMaxY() - 5*pixelHeight));
        g2.draw( new Line2D.Double(-5*pixelWidth,getMaxY()-5*pixelHeight,5*pixelWidth,getMaxY()-5*pixelHeight));
        g2.draw( new Line2D.Double(5*pixelWidth,getMaxY()-5*pixelHeight,0,getMaxY()));
        
        // Draw Label and stick if set
        if (hasXYLables()) {
        	  int intMinY = (int)Math.ceil(getMinY());	
        	  
        	  // draw Y label
        	  for (int valueY = intMinY; valueY <= maxY; valueY += getStepYLabel()) {
        	  	  if(valueY != 0) {			 // do not draw 0 might overlap with x	
        	  		  g2.translate(3*pixelWidth,valueY - pixelHeight);
        	  		  g2.scale(pixelWidth,-pixelHeight);
        	  		  g2.drawString(String.valueOf(valueY), 0, 0);
        	  		  g2.setTransform(g2AfterFixCoor);
        	  	  }
        	  }
        	  
        	  // draw X label
        	  int intMinX = (int)getMinX();
        	  for (int valueX = intMinX; valueX <= maxX; valueX+= getStepXLabel()) {
         		 g2.translate(valueX - 3*pixelWidth,3*pixelHeight);
         		 g2.scale(pixelWidth,-pixelHeight);
                 g2.drawString(String.valueOf(valueX), 0, 0);
   	           	 g2.setTransform(g2AfterFixCoor);
   	           	 g2.draw(new Line2D.Double(valueX,0,valueX,3*pixelHeight));		//draw tick at axis if liked
        	  }
        }
      
        // draw Background Horizontal Lines if set
        if (hasHorizontalLine())	  {
        	  g2.setColor(Color.GRAY);	
        	  int intMinY = (int)Math.ceil(getMinY());	
        	  for (int valueY = intMinY; valueY <= maxY; valueY += getStepYLabel()) {
        	  	  if(valueY != 0) {			 // do not draw 0 might overlap with x axis
        	  		  g2.draw(new Line2D.Double(minX,(double)valueY,maxX,(double)valueY));
        	  	  }
        	  }
        	  g2.setColor(Color.BLACK); //return default color Black
        }
        	  
   
        // plot the point
		g2.setColor(Color.BLUE);
		for (int i = 0; i < ds.count(); i++) {
			double x = ds.getDataPointAt(i).getX();
			double y = ds.getDataPointAt(i).getY();
			g2.fill(new Rectangle2D.Double(x,y,5*pixelWidth,5*pixelHeight) );	
		}
		
        // draw TrendLine if set
        if (hasTrendLine()) {
        	double xFirst = ds.getMinX();
        	double yFirst  = trendLine.getYValue(xFirst);
        	
        	double xSecond = ds.getMaxX();
        	double ySecond = trendLine.getYValue(xSecond);
        	
        	g2.setColor(Color.BLUE);	
        	g2.draw(new Line2D.Double(xFirst,yFirst,xSecond,ySecond));
        	g2.setColor(Color.BLACK); 		//return default color Black
        }
        
        if (hasEquation()) {
        	  double xMin = ds.getMinX();
        	  double yAtXMin  = ds.getYAtMinX(xMin);
        	  double yFirst = trendLine.getYValue(xMin);
        	  double yDraw = 0.0;
        	  
        	  // not draw out of panel
        	  if ( (yFirst > getMaxY()) || (yFirst < getMinY())) {
        		  yDraw = yAtXMin;
        	  }
        	  else { yDraw = yFirst; }
        	  
        	  g2.setColor(Color.RED);
        	  
        	  g2.translate(xMin + 5*pixelWidth,yDraw);
	  		  g2.scale(pixelWidth,-pixelHeight);
	  		  g2.drawString(trendLine.getTrendLineFormula(), 0, 0);
	  		  
	  		  g2.setColor(Color.BLACK); 	//return default color Black
	  		  g2.setTransform(g2AfterFixCoor);
        }
		
	}
	

}
