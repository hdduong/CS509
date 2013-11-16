package model;

import static org.junit.Assert.*;

import java.io.File;

import model.Model.GraphType;

import org.junit.Test;

public class TestModel {

	@Test
	public void testModal() {
		Model model = new Model();
		DataSet ds = model.getDataSet();
		
		String filePath = "src"+File.separator+"resources"+File.separator+"data5Points.txt";
		assertTrue(ds.loadDataSetFromFile(filePath));
		assertTrue(ds.count() == 5);
		
		ColumnGraph columnGraph = new ColumnGraph(ds, 640.0, 480.0);
		
		model.setGraph(columnGraph );
		model.setGraphType(GraphType.COLUMN);
		
		assertEquals(GraphType.COLUMN, model.getGraphType());
		assertEquals(true, columnGraph.equals(model.getGraph()) );
		
		
		CartesianPlot cartesianPlot = new CartesianPlot(ds, 640.0, 480.0);
		
		model.setGraph(cartesianPlot );
		model.setGraphType(GraphType.CARTESIAN);
		
		assertEquals(GraphType.CARTESIAN, model.getGraphType());
		assertEquals(true, cartesianPlot.equals(model.getGraph()) );
	}

}
