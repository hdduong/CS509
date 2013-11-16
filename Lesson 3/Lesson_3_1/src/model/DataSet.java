package model;

import java.awt.List;
import java.io.*; 
import java.security.interfaces.DSAKey;
import java.util.ArrayList;


public class DataSet {
	ArrayList<DataPoint> dataset;

	String s="This is used to test git from linglong";
	
	DataSet(){
		dataset = new ArrayList<DataPoint>();
	}
	
	public ArrayList<DataPoint> getDataSet() {
		return this.dataset;
	}

	
	public int addDataPoint(DataPoint d){ 
		int index  = dataset.size();
	
		dataset.add(d);
		
		return index;
	}
	
	public int addDataPointAt(int addAt, DataPoint d){ 
		int index  = dataset.size();
	
		dataset.add(addAt,d);
		
		return index;
	}
	
	public int removeDataPointAt(int index){ 
		dataset.remove(index);
		
		return dataset.size();
	}
	
	public int setBlankDataSet() {
		
		for (int i = 0; i < dataset.size(); i++)
			 removeDataPointAt(i);
		
		return dataset.size();	// should be 0
		 
	}
	
	public int count() {
		return dataset.size();
	}
	
	public DataPoint getDataPointAt(int index) {
		return dataset.get(index);
	}
	
	public double getMaxX() {
		// if ds.size
		double maxX = dataset.get(0).getX();
		for (int i = 0; i < dataset.size();i ++ ) {
			if (maxX < dataset.get(i).getX() ) {
				maxX = dataset.get(i).getX();			
			}
		}
		return maxX;
	}
	
	public double getMinX() {
		// if ds.size
		double minX = dataset.get(0).getX();
		for (int i = 0; i < dataset.size();i ++ ) {
			if (minX > dataset.get(i).getX() ) {
				minX = dataset.get(i).getX();			
			}
		}
		return minX;
	}
	
	public double getYAtMinX(double minX) {
		int index = 0;
		
		for (int i = 0; i < dataset.size();i ++ ) {
			if (minX == dataset.get(i).getX() ) {
				index = i;
				break;
			}
		}
		return dataset.get(index).getY();
	}

}
