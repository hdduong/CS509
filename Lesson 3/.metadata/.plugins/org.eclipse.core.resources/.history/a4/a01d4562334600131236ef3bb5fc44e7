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
		assertNotNull(ds.dataset);
	}

	public void testLoadData(){
		assertTrue(ds.dataset.size()==0);
		String filePath = "src"+File.separator+"resources"+File.separator+"dataToBeLoad.txt";
		assertTrue(ds.loadDataSetFromFile(filePath));
		assertTrue(ds.dataset.size()==6);
		assertTrue(ds.dataset.get(5).y==-8.9);
		filePath = "";
		assertFalse(ds.loadDataSetFromFile(filePath));
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
		ds.dataset.add(dp); 
		assertTrue(ds.dataset.size()==1);
		ds.deleteDataPoint(dp);
		assertTrue(ds.dataset.size()==0);
	}
	
	public void testDeleteDatePonitGivenIndex(){
		DataPoint dp1 = new DataPoint(3,9);
		DataPoint dp2 = new DataPoint(5.4,6.7);
		ds.dataset.add(dp1);
		ds.dataset.add(dp2);
		assertTrue(ds.dataset.size()==2);
		assertTrue(ds.deleteDataPoint(1));
		assertTrue(ds.dataset.size()==1);
		assertFalse(ds.deleteDataPoint(7));
	}
	
	public void testEditDataPoint(){ 
		DataPoint dp = new DataPoint(5.4,6.7);
		ds.dataset.add(dp);
		assertTrue(ds.editDataPoint(0, 100, 200));
		DataPoint tmp = ds.dataset.get(0);
		assertTrue(tmp.x==100);
		assertTrue(tmp.y==200);
		assertFalse(ds.editDataPoint(10, 100, 200));
	}
}
