package model;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import controller.LoadDataController;

import view.Main;

public class TestColumnGraph {

	@Test
	public void testColumnWithSmallRanges() {
		Main main = new Main();
		Model m = main.getModel();
		DataSet ds = m.getDataSet();
	
		String filePath = "src"+File.separator+"resources"+File.separator+"data5Points.txt";
		LoadDataController ldc = new LoadDataController(m);
		assertTrue(ldc.loadFromFile(new File(filePath), main));
		assertTrue(ds.count() == 5);
		 
		ColumnGraph columnGraph = new ColumnGraph(ds, 640.0, 480.0);
		
		assertEquals(columnGraph.getPanelWidth(), 640.0, 0.01);
		assertEquals(columnGraph.getPanelHeight(), 480.0, 0.01);
		
		columnGraph.setHorizontalLine(true);
		assertEquals(true, columnGraph.hasHorizontalLine());
		
		columnGraph.setXYLabels(true);
		assertEquals(true, columnGraph.hasXYLables());
		
		
		// if not enableTrendLine then not enableEquation
		columnGraph.calculateMaxMin();
		columnGraph.setStepXLabel();
		columnGraph.setStepYLabel();
		
		assertEquals(6.0, columnGraph.getMaxX(),0.01);
		assertEquals(-0.1, columnGraph.getMinX(),0.01);
		assertEquals(2.0, columnGraph.getMaxY(),0.01);
		assertEquals(-3.5, columnGraph.getMinY(),0.01);
		
		assertEquals(1.0, columnGraph.getStepXLabel(),0.01);
		assertEquals(1.0, columnGraph.getStepYLabel(),0.01);
		
	}
	
	@Test
	public void testCartesianPlotWithLargeRanges() {
		Main main = new Main();
		Model m = main.getModel();
		DataSet ds = m.getDataSet();
	
		String filePath = "src"+File.separator+"resources"+File.separator+"data44Points.txt";
		LoadDataController ldc = new LoadDataController(m);
		assertTrue(ldc.loadFromFile(new File(filePath), main));
		assertTrue(ds.count() == 44);
		
		ColumnGraph columnGraph = new ColumnGraph(ds, 640.0, 480.0);
		
		assertEquals(columnGraph.getPanelWidth(), 640.0, 0.01);
		assertEquals(columnGraph.getPanelHeight(), 480.0, 0.01);
		
		columnGraph.setHorizontalLine(true);
		assertEquals(true, columnGraph.hasHorizontalLine());
		
		columnGraph.setXYLabels(true);
		assertEquals(true, columnGraph.hasXYLables());
		
		
		// if not enableTrendLine then not enableEquation
		columnGraph.calculateMaxMin();
		columnGraph.setStepXLabel();
		columnGraph.setStepYLabel();
		
		assertEquals(45.0, columnGraph.getMaxX(),0.01);
		assertEquals( -0.1, columnGraph.getMinX(),0.01);
		assertEquals( 101.0, columnGraph.getMaxY(),0.01);
		assertEquals(-100.0, columnGraph.getMinY(),0.01);
		
		assertEquals(5, columnGraph.getStepXLabel(),0.01);
		assertEquals(33, columnGraph.getStepYLabel(),0.01);

	}


}
