package model;

import java.awt.List;
import java.io.*; 
import java.util.ArrayList;

public class DataSet {
	
	ArrayList<DataPoint> dataset;
	
	DataSet(){
		dataset = new ArrayList<DataPoint>();
	}
	
 
	public boolean loadDataSetFromFile(String filePath) {
		 
			try (BufferedReader br=new BufferedReader(new FileReader(filePath))){
			 
				String s;
				while(null!=(s=br.readLine())){
							String[] data = s.split(",");
							DataPoint dp=new DataPoint(Double.parseDouble(data[0]),Double.parseDouble(data[1]));
							this.addDataPoint(dp);
						} 
				
			  } catch (IOException e) { 
				e.printStackTrace();
				return false;
			 }
			 return true;
		
	}
	
	public boolean saveDataSetToFile(String filePath){
		try(BufferedWriter wr=new BufferedWriter(new FileWriter(filePath))){
			for(DataPoint dp:dataset){
				wr.write(dp.x+","+dp.y);
				wr.newLine();
			}
		}		
		catch(IOException e){ 
			e.printStackTrace();
			return false;
	 }
	 return true;
		
	}

	public boolean addDataPoint(DataPoint d){ 
		return dataset.add(d);
	}
	
	public boolean deleteDataPoint(DataPoint d){ 
		return dataset.remove(d);		 
	}
	public boolean deleteDataPoint(int index){ 
		if(dataset.size()>index){
			dataset.remove(index);
			return true;
		}
		return false;		 
	}
	
	public boolean  editDataPoint(int index, int x, int y){
		boolean success=false;
		if(dataset.size()>index){
			success=true;
			DataPoint d=dataset.get(index);		
			d.x=x;
			d.y=y;
		}
		return success;
	}
}
