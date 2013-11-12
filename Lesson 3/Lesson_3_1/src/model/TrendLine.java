package model;

import java.text.DecimalFormat;

public class TrendLine {
	DataSet ds;
	double slope;
	double intercept;

	
	public TrendLine(DataSet dSet) {
		this.ds = dSet;
		compute();
	}
	
	public void compute() {
		double sumX = 0.0;
		double sumY = 0.0;
		double averageX = 0.0;
		double averageY = 0.0;
		
		double xxbar = 0.0;
		double xybar = 0.0;
		
		for (int i = 0; i < this.ds.count(); i++) {
			sumX += this.ds.getDataPointAt(i).getX();
			sumY += this.ds.getDataPointAt(i).getY();
		}
		
		averageX = sumX/this.ds.count();
		averageY = sumY/this.ds.count();
		
		for (int i= 0; i< this.ds.count();i++){
			xxbar += (this.ds.getDataPointAt(i).getX() - averageX) * (this.ds.getDataPointAt(i).getX() - averageX);
			xybar += (this.ds.getDataPointAt(i).getX() - averageX) * (this.ds.getDataPointAt(i).getY() - averageY);
		}
		
		slope = xybar/xxbar;
		intercept = averageY - slope*averageX;
	}
	
	public double getSlope() { return this.slope; }
	
	public double getIntercept() { return this.intercept; }
	
	public String getTrendLineFormula() {
		DecimalFormat df= new DecimalFormat("#0.0000");  
		
		String strSlope= df.format(getSlope());  
		String strIntercept= df.format(getIntercept());  
		String formula = "";
		
		if ( (getIntercept() > 0.0) ) {
			formula =  "y   = " + strSlope + "*x + " + strIntercept;
		}
		else {
			formula =  "y   = " + strSlope + "*x " + strIntercept;
		}
		return formula;
	}
	
	public double getYValue(double x) {
		double y  = slope + x*intercept;
		return y;
	}
	
	
}
