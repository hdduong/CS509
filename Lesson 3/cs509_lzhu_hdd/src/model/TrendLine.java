package model;

/* *
 * TrendLine equation: y=ax+b, a is slope and b is the intercept. 
 * 
 *
 */


public class TrendLine {

	double slope;
	double intercept;
	
	
	
	TrendLine(double slope, double intercept){
		this.slope = slope;
		this.intercept = intercept;
	}
	
	
	/**
	 * Compute the trend line based on the data passed in
	 * 		  Regression Equation(y) = a + bx 
	 * 	      Slope(b) = (N*SumXY - (SumX)(SumY)) / (N*SumX2 - (SumX)2)
	 * 	      Intercept(a) = (SumY - b(SumX)) / N
	 *		  x and y are the variables.
     *        b = The slope of the regression line 
     *        a = The intercept point of the regression line and the y axis.	
     *        N = Number of values or elements 
     *        X = x value
     *        Y = y value
     *        SumXY = Sum of the product of first and Second Scores
     *        SumX = Sum of First Scores
     *        SumY = Sum of Second Scores
     *        SumX2 = Sum of square First Scores
	 * 
	 */
	void compute(DataSet data){
		double n=data.set.size();
		double sumXY=0, sumX=0, sumY=0, sumX2=0;
		double x,y;
		for(DataPoint dp: data.set){
			x=dp.x;
			y=dp.y;
			sumXY += x*y;
			sumX  += x;
			sumY  += y;
			sumX2 += x*x;
		}
		slope = (n*sumXY - (sumX)*(sumY)) / (n*sumX2 - sumX * sumX);
		intercept = (sumY - slope*(sumX)) / n; 
		
	}
	
	
}
