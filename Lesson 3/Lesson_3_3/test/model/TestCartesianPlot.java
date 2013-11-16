package model;

import static org.junit.Assert.*;

import java.awt.Graphics;
import java.io.File;

import org.junit.Test;

import controller.LoadDataController;

import view.Main;

public class TestCartesianPlot {

	@Test
	public void testCartesianPlotWithSmallRanges() {
		Main main = new Main();
		Model m = main.getModel();
		DataSet ds = m.getDataSet();
		
	
		String filePath = "src"+File.separator+"resources"+File.separator+"data5Points.txt";
		LoadDataController ldc = new LoadDataController(m);
		assertTrue(ldc.loadFromFile(new File(filePath), main));
		assertTrue(ds.count() == 5);
		
		CartesianPlot cartesianPlot = new CartesianPlot(ds, 640.0, 480.0);
		
		assertEquals(cartesianPlot.getPanelWidth(), 640.0, 0.01);
		assertEquals(cartesianPlot.getPanelHeight(), 480.0, 0.01);
		
		cartesianPlot.setTrendLine(true);
		assertEquals(true, cartesianPlot.hasTrendLine());
		 
		cartesianPlot.setEquaiton(true);
		assertEquals(true, cartesianPlot.hasEquation());
		
		cartesianPlot.setHorizontalLine(true);
		assertEquals(true, cartesianPlot.hasHorizontalLine());
		
		cartesianPlot.setXYLabels(true);
		assertEquals(true, cartesianPlot.hasXYLables());
		
		
		// if not enableTrendLine then not enableEquation
		cartesianPlot.setTrendLine(false);
		assertEquals(false, cartesianPlot.hasTrendLine());
		assertEquals(false, cartesianPlot.hasEquation());
		
		cartesianPlot.calculateMaxMin();
		cartesianPlot.setStepXLabel();
		cartesianPlot.setStepYLabel();
		
		assertEquals(1.05, cartesianPlot.getMaxX(),0.01);
		assertEquals(-3.6225, cartesianPlot.getMinX(),0.01);
		assertEquals(1.05, cartesianPlot.getMaxY(),0.01);
		assertEquals(-1.806, cartesianPlot.getMinY(),0.01);
		
		assertEquals(1.0, cartesianPlot.getStepXLabel(),0.01);
		assertEquals(1.0, cartesianPlot.getStepYLabel(),0.01);
		
	}
	
	@Test
	public void testCartesianPlotWithLargeRanges() {
		Main main = new Main();
		main.setVisible(true);
		main.getGraphPanel().setVisible(true);
		
		Model m = main.getModel(); 
		DataSet ds = m.getDataSet(); 
	
		String filePath = "src"+File.separator+"resources"+File.separator+"data44Points.txt";
		LoadDataController ldc = new LoadDataController(m);
		assertTrue(ldc.loadFromFile(new File(filePath), main));
		assertTrue(ds.count() == 44);
		 
		CartesianPlot cartesianPlot = new CartesianPlot(ds, 640.0, 480.0);
		m.setGraph(cartesianPlot);
		
		assertEquals(cartesianPlot.getPanelWidth(), 640.0, 0.01);
		assertEquals(cartesianPlot.getPanelHeight(), 480.0, 0.01);
		
		cartesianPlot.setTrendLine(false);
		assertEquals(false, cartesianPlot.hasTrendLine());
		 
		cartesianPlot.setEquaiton(false);
		assertEquals(false, cartesianPlot.hasEquation());
		
		cartesianPlot.setHorizontalLine(false);
		assertEquals(false, cartesianPlot.hasHorizontalLine());
		
		cartesianPlot.setXYLabels(false);
		assertEquals(false, cartesianPlot.hasXYLables());
		
		// if not enableTrendLine then not enableEquation
		cartesianPlot.setTrendLine(true);
		assertEquals(true, cartesianPlot.hasTrendLine());
		assertEquals(false, cartesianPlot.hasEquation());
		
 
		cartesianPlot.calculateMaxMin();
		cartesianPlot.setStepXLabel();
		cartesianPlot.setStepYLabel();
		
		main.getGraphPanel().repaint();
		
		assertEquals(101.85, cartesianPlot.getMaxX(),0.01);
		assertEquals(-102.9, cartesianPlot.getMinX(),0.01);
		assertEquals(105.0, cartesianPlot.getMaxY(),0.01);
		assertEquals(-105.0, cartesianPlot.getMinY(),0.01);
		
		assertEquals(25, cartesianPlot.getStepXLabel(),0.01);
		assertEquals(35, cartesianPlot.getStepYLabel(),0.01);
		

	}

}
