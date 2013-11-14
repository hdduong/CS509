package model;

public class DataPoint {
	
	private double x;
	private double y;
	
	public DataPoint(double x, double y){
		this.x=x;
		this.y=y;
	}
	
	public void SetX(double newX) {
		this.x = newX;
	}
	
	public void SetY(double newY) {
		this.y = newY;
	}
	
	public void SetXY(double newX, double newY) {
		this.x = newX;
		this.y = newY;
	}
	

	
	public double getX(){ return this.x; }
	public double getY(){ return this.y; }
	
	public String toString() {
		return Double.toString(this.x) + "," + Double.toString(this.y);
	}
	
	public boolean toDouble(String xyStr) {
		String delims = ",";
		String[] tokens = xyStr.split(delims);
		
		if ( (tokens[0]== null) || (tokens[1] == null) ) {
			return false;
		}
		
		this.x = Double.parseDouble(tokens[0]);
		this.y = Double.parseDouble(tokens[1]);
		
		return true;
	}
}
