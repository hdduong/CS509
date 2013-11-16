package model;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class TestTrendLine {

	@Test
	public void testTrendLine() {
		Model m = new Model();
		DataSet ds = m.getDataSet();
	
		String filePath = "src"+File.separator+"resources"+File.separator+"data5Points.txt";
		assertTrue(ds.loadDataSetFromFile(filePath));
		assertTrue(ds.count() == 5);
		
		TrendLine trendLine = new TrendLine(ds);
		
		assertEquals(0.248, trendLine.getSlope(),0.001);
		assertEquals(-0.337, trendLine.getIntercept(),0.001);
		
		assertEquals(trendLine.getYValue(0.0), -0.33770612847649517,0.001);
		assertEquals(trendLine.getXValue(1.0),  5.377028096557182,0.001);
		assertEquals(true,trendLine.getTrendLineFormula().equals("y   = 0.2488*x -0.3377") );
		
	}

}
