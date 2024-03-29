package model;

import java.io.File;

import junit.framework.TestCase;

public class TestDataSet extends TestCase {

	DataSet ds;
	
	
	protected void setUp() throws Exception {
		ds=new DataSet();
	}
	
	public void testDataSetInit(){
		assertNotNull(ds);
		assertNotNull(ds.set);
	}

	public void testLoadData(){
		assertTrue(ds.set.size()==0);
		String filePath = "src"+File.separator+"resources"+File.separator+"dataToBeLoad.txt";
		assertTrue(ds.loadDataSetFromFile(filePath));
		assertTrue(ds.set.size()==6);
		assertTrue(ds.set.get(5).getY()==-8.9); 
	}
	
	public void testLoadDataWithEmptyFile(){
		assertTrue(ds.set.size()==0);
		String filePath =  "";
		assertFalse(ds.loadDataSetFromFile(filePath));
	}
	
	public void testLoadDataWithInvalidData(){
		assertTrue(ds.set.size()==0);
		String filePath = "src"+File.separator+"resources"+File.separator+"dataToBeLoadWithInvalidSymbol.txt";
		assertTrue(ds.loadDataSetFromFile(filePath));
		assertTrue(ds.set.size()==2);
		assertTrue(ds.set.get(1).getY()==5); 
	}
	
	public void testLoadDataWithEmptyLine(){
		assertTrue(ds.set.size()==0);
		String filePath = "src"+File.separator+"resources"+File.separator+"dataToBeLoadWithEmptyLine.txt";
		assertTrue(ds.loadDataSetFromFile(filePath));
		assertTrue(ds.set.size()==1);
		assertTrue(ds.set.get(0).getY()==2); 
	}
	
	
	
	
	public void testSaveData(){
		String loadFilePath = "src"+File.separator+"resources"+File.separator+"dataToBeLoad.txt";
		ds.loadDataSetFromFile(loadFilePath);
		String saveFilePath = "src"+File.separator+"resources"+File.separator+"dataSaved.txt"; 
		assertTrue(ds.saveDataSetToFile(saveFilePath));
		saveFilePath = "";
		assertFalse(ds.saveDataSetToFile(saveFilePath));
	}
	
	
	public void testDeleteDataPointGivenObject(){
		DataPoint dp = new DataPoint(3,9);
		ds.set.add(dp); 
		assertTrue(ds.set.size()==1);
		ds.deleteDataPoint(dp);
		assertTrue(ds.set.size()==0);
	}
	
	public void testDeleteDatePonitGivenIndex(){
		DataPoint dp1 = new DataPoint(3,9);
		DataPoint dp2 = new DataPoint(5.4,6.7);
		ds.set.add(dp1);
		ds.set.add(dp2);
		assertTrue(ds.set.size()==2);
		assertTrue(ds.deleteDataPoint(1));
		assertTrue(ds.set.size()==1);
		assertFalse(ds.deleteDataPoint(7));
	}
	
	public void testEditDataPoint(){ 
		DataPoint dp = new DataPoint(5.4,6.7);
		ds.set.add(dp);
		assertTrue(ds.editDataPoint(0, 100, 200));
		DataPoint tmp = ds.set.get(0);
		assertTrue(tmp.getX()==100);
		assertTrue(tmp.getY()==200);
		assertFalse(ds.editDataPoint(10, 100, 200));
	}
}
