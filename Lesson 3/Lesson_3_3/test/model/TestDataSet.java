package model;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class TestDataSet {

	@Test
	public void testLoadData() {
		Model m = new Model();
		DataSet ds = m.getDataSet();
		
		assertTrue(ds.count() == 0);
		String filePath = "src"+File.separator+"resources"+File.separator+"data10Points.txt";
		assertTrue(ds.loadDataSetFromFile(filePath));
		assertTrue(ds.count() == 10);
		assertTrue(ds.getDataPointAt(5).getX()==-62.19); 
		
	}

	@Test
	public void testLoadDataWithEmptyFile(){
		Model m = new Model();
		DataSet ds = m.getDataSet();
		
		assertTrue(ds.count()==0);
		String filePath =  "";
		assertFalse(ds.loadDataSetFromFile(filePath));
	}
	
	@Test
	public void testLoadDataWithEmptyLine(){
		Model m = new Model();
		DataSet ds = m.getDataSet();
		
		assertTrue(ds.count()==0);
		String filePath = "src"+File.separator+"resources"+File.separator+"dataToBeLoadWithEmptyLine.txt";
		assertTrue(ds.loadDataSetFromFile(filePath));
		assertTrue(ds.count()==1);
		assertTrue(ds.getDataPointAt(0).getY()==2); 
	}
	
	@Test
	public void testSaveData(){
		Model m = new Model();
		DataSet ds = m.getDataSet();
		
		String loadFilePath = "src"+File.separator+"resources"+File.separator+"data10Points.txt";
		assertTrue(ds.loadDataSetFromFile(loadFilePath) );
		String saveFilePath = "src"+File.separator+"resources"+File.separator+"dataSaved.txt"; 
		assertTrue(ds.saveDataSetToFile(saveFilePath));
		saveFilePath = "";
		assertFalse(ds.saveDataSetToFile(saveFilePath));
	}
	
	@Test
	public void testDeleteDataPointAtIndex(){
		Model m = new Model();
		DataSet ds = m.getDataSet();
		
		DataPoint dp = new DataPoint(3,9);
		assertEquals(0, ds.addDataPoint(dp) ); 
		assertEquals(1, ds.count());
		
		assertEquals(0,  ds.removeDataPointAt(0) );
	}
	
	
	@Test
	public void testAddDataPointAtIndex() {
		Model m = new Model();
		DataSet ds = m.getDataSet();
		
		DataPoint dp = new DataPoint(3,9);
		assertEquals(0, ds.addDataPoint(dp) ); 
		assertEquals(1, ds.count());
		
		DataPoint dp2 = new DataPoint(9,3);
		ds.addDataPointAt(ds.count(), dp2);
		assertEquals(2, ds.count());
		assertEquals(9.0, ds.getDataPointAt(1).getX(),0.01);
	}
	
	@Test
	public void testGetMinX() {
		Model m = new Model();
		DataSet ds = m.getDataSet();
		
		DataPoint dp = new DataPoint(3,9);
		assertEquals(0, ds.addDataPoint(dp) ); 
		assertEquals(1, ds.count());
		
		DataPoint dp2 = new DataPoint(9,3);
		ds.addDataPointAt(ds.count(), dp2);
		assertEquals(2, ds.count());
		
		assertEquals(3.0, ds.getMinX(), 0.01);

	}
	
	@Test
	public void testGetYAtMinX() {
		Model m = new Model();
		DataSet ds = m.getDataSet();
		
		DataPoint dp = new DataPoint(3.0,9.0);
		assertEquals(0, ds.addDataPoint(dp) ); 
		assertEquals(1, ds.count());
		
		DataPoint dp2 = new DataPoint(9.0,3.0);
		ds.addDataPointAt(ds.count(), dp2);
		assertEquals(2, ds.count());
		
		assertEquals(9.0, ds.getYAtMinX(3.0), 0.01);
	}
	
	@Test
	public void testGetMaxX() {
		Model m = new Model();
		DataSet ds = m.getDataSet();
		
		DataPoint dp = new DataPoint(3.0,9.0);
		assertEquals(0, ds.addDataPoint(dp) ); 
		assertEquals(1, ds.count());
		
		DataPoint dp2 = new DataPoint(9.0,3.0);
		ds.addDataPointAt(ds.count(), dp2);
		assertEquals(2, ds.count());
		
		assertEquals(9.0, ds.getMaxX(), 0.01);

	}
	
	@Test
	public void testSetBlankDataSet() {
		Model m = new Model();
		DataSet ds = m.getDataSet();
		
		DataPoint dp = new DataPoint(3.0,9.0);
		assertEquals(0, ds.addDataPoint(dp) ); 
		assertEquals(1, ds.count());
		
		DataPoint dp2 = new DataPoint(9.0,3.0);
		ds.addDataPointAt(ds.count(), dp2);
		assertEquals(2, ds.count());
		
		assertEquals(2, ds.setBlankDataSet());
		assertEquals(0, ds.count());

	}
	
}
