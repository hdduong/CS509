package model;

import java.awt.List;
import java.io.*; 
import java.util.ArrayList;

public class DataSet {
	
	ArrayList<DataPoint> dataset;
	
	DataSet(){
		dataset = new ArrayList<DataPoint>();
	}
	
	public void loadDataSetFromFile(String filePath) throws IOException {
		BufferedReader br;
		 
			br=new BufferedReader(new FileReader(filePath));
			String s;
			while(null!=(s=br.readLine())){
				String[] data = s.split(",");
				DataPoint dp=new DataPoint(Integer.parseInt(data[0]),Integer.parseInt(data[1]));
				this.addDataPoint(dp);
			}
		 
		
	}
	
	public boolean saveDataSetToFile(String filePath){
		
	}

	public boolean addDataPoint(DataPoint d){ 
		return dataset.add(d);
	}
	
	public boolean deleteDataPoint(DataPoint d){ 
		return dataset.remove(d);		 
	}
	public boolean deleteDataPoint(int index){ 
		return dataset.remove(index)==null;		 
	}
	
	public boolean  editDataPoint(int index, int x, int y){
		boolean success=false;
		if(dataset.size()>index)
			success=true;
		DataPoint d=dataset.get(index);		
		d.x=x;
		d.y=y;
		return success;
	}
}
