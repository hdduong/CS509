package model;

import java.io.File;

import junit.framework.TestCase;

public class TestTrendLine extends TestCase {

	public void testTrendLine(){
		TrendLine tline = new TrendLine(3,4);
		assertEquals(true,tline.slope==3);
		assertEquals(true,tline.intercept==4);
	}
	
	public void testComputeTrendLine(){
		TrendLine tline = new TrendLine(3,4);
		DataSet ds = new DataSet();
		String filePath = "src"+File.separator+"resources"+File.separator+"dataToComputeTrendLine.txt";
		ds.loadDataSetFromFile(filePath);
		tline.compute(ds);
		assertEquals(3.0,tline.intercept);
		assertEquals(4.0,tline.slope);
	}
	
	
}
