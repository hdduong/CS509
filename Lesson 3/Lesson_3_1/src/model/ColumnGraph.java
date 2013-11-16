package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class ColumnGraph extends Graph {

	double panelWidth;
	double panelHeight;
	public ColumnGraph(DataSet dataset,double pnlWidth, double pnlHeight) {
		super(dataset);
		
		this.panelWidth = pnlWidth;
		this.panelHeight = pnlHeight;
	}
	

	public double getPanelWidth() {return panelWidth; }
	public double getPanelHeight() {return panelHeight; }
	
	public void calculateMaxMin() {
		
		maxX = 1.0;	// always start to draw at 1
		minX = -0.1; 
		maxY = 0.5;
		minY = -0.5; 
		
		
		for (int i = 0; i < ds.count();i ++ ) {
			maxX++;				// number of columns
			
			if (maxY < ds.getDataPointAt(i).getY() ) {
				maxY = ds.getDataPointAt(i).getY() + 1.0;			//align border top
			}
			if (maxY < ds.getDataPointAt(i).getX() ) {
				maxY = ds.getDataPointAt(i).getX() + 1.0;			//align border top
			}
			
			if (minY > ds.getDataPointAt(i).getX() ) {
				minY = ds.getDataPointAt(i).getX() - 1.0;			//align border bottom
			}
			
			if (minY > ds.getDataPointAt(i).getY() ) {
				minY = ds.getDataPointAt(i).getY() - 1.0;		    //align border bottom
			}
		}
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
        
        // Draw columns
        for (int i = 0; i < ds.count(); i++) {
            Double x = (Double)ds.getDataPointAt(i).getX();
            Double y = (Double)ds.getDataPointAt(i).getY();
            
            g2.setColor(Color.GREEN);
           if (x > 0) {
        	   g2.fill(new Rectangle2D.Double( (double)(i+1 - (double)(1.0/3) )  ,0, 1.0/3,x));
           }
           else {
        	   g2.fill(new Rectangle2D.Double((double)(i+1 - (double)(1.0/3) ), x, (double)(1.0/3) , Math.abs(x)));
           }
           
           g2.setColor(Color.PINK);
           if (y > 0) {
         	   g2.fill(new Rectangle2D.Double( (double)(i+1.0)  ,0, 1.0/3,y));
            }
            else {
         	   g2.fill(new Rectangle2D.Double((double)(i+1), y, (double)1.0/3 , Math.abs(y)));
            }

         }
        
        // Draw Label and stick if set
        g2.setColor(Color.BLUE);
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
         		 g2.translate(valueX - 3*pixelWidth,-1.0/2.0);
         		 g2.scale(pixelWidth,-pixelHeight);
                 g2.drawString(String.valueOf(valueX), 0, 0);
   	           	 g2.setTransform(g2AfterFixCoor);
   	           	 g2.draw(new Line2D.Double(valueX,0,valueX,3*pixelHeight));		//draw tick at axis if liked
        	  }
        }
		
	}
}
