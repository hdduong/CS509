package model;

public class DataPoint {
	
	private double x;
	private double y;
	
	public DataPoint(double x, double y){
		this.x=x;
		this.y=y;
	}
	
	public double getX(){ return this.x; }
	public double getY(){ return this.y; }
	
	public String toString() {
		return Double.toString(this.x) + "," + Double.toString(this.y);
	}
	 
}
