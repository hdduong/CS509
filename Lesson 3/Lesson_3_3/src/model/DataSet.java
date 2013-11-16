package model;

import java.awt.List;
import java.io.*; 
import java.security.interfaces.DSAKey;
import java.util.ArrayList;


public class DataSet {
	ArrayList<DataPoint> dataset;

	final int MAX_SIZE = 2048;
	
	DataSet(){
		dataset = new ArrayList<DataPoint>();
	}
	
	public boolean loadDataSetFromFile(String filePath) {
		 
		try (BufferedReader br=new BufferedReader(new FileReader(filePath))){
		 
			String s;
			while(null!=(s=br.readLine())){
						String[] data = s.split(","); 
						try{
							this.addDataPoint(Double.parseDouble(data[0]),Double.parseDouble(data[1]));
						} catch(NumberFormatException | NullPointerException e){
							
							e.printStackTrace();
							continue;
						}
					} 
			 
		  } catch (IOException e) { 
			  e.printStackTrace();
			  return false;
		 }
		 return true;
	}

	public boolean saveDataSetToFile(String filePath){
		try(PrintStream ps =new PrintStream(new File(filePath))){
			for(DataPoint dp:dataset){
				ps.print(dp.getX()+","+dp.getY());
				ps.println();
			}
		}		
		catch(IOException e){ 
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	
	public boolean addDataPoint(double x, double y){ 
		if(this.dataset.size()>=MAX_SIZE){
			return false;
		} 
		DataPoint d =new DataPoint(x,y);
		return dataset.add(d);
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
	
	public double getMaxX() {
		double maxX = dataset.get(0).getX();
		for (int i = 0; i < dataset.size();i ++ ) {
			if (maxX < dataset.get(i).getX() ) {
				maxX = dataset.get(i).getX();			
			}
		}
		return maxX;
	}
	
	public double getMinX() {
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

	public int count() { return dataset.size(); }
	
	public int setBlankDataSet() {
		int removeCount = dataset.size();
		
		for (int i = dataset.size() - 1; i >= 0; i--)
			 removeDataPointAt(i);
		
		return removeCount;	// number of datapoints removed
		 
	}
	
	public DataPoint getDataPointAt(int index) { return dataset.get(index); }
}
