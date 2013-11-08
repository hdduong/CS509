package model;

import java.awt.List;
import java.io.*; 
import java.util.ArrayList;

public class DataSet {
	
	public ArrayList<DataPoint> set;
	final int MAX_SIZE =2048;
	DataSet(){
		set = new ArrayList<DataPoint>();
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
		try(BufferedWriter wr=new BufferedWriter(new FileWriter(filePath))){
			for(DataPoint dp:set){
				wr.write(dp.getX()+","+dp.getY());
				wr.newLine();
			}
		}		
		catch(IOException e){ 
			e.printStackTrace();
			return false;
	 }
	 return true;
		
	}
	
	public boolean addDataPoint(double x, double y){ 
		if(this.set.size()>=MAX_SIZE){
			return false;
		} 
		DataPoint d =new DataPoint(x,y);
		return set.add(d);
	}
	
	public boolean deleteDataPoint(DataPoint d){ 
		return set.remove(d);		 
	}
	public boolean deleteDataPoint(int index){ 
		if(set.size()>index){
			set.remove(index);
			return true;
		}
		return false;		 
	}
	
	public boolean  editDataPoint(int index, int x, int y){
		boolean success=false;
		if(set.size()>index){
			success=true;
			DataPoint d=set.get(index);		
			d.setX(x);
			d.setY(y);
		}
		return success;
	}
}
