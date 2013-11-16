package controller;

import static org.junit.Assert.*;

import java.io.File;

import javax.swing.JFileChooser;

import model.Model;
import model.Model.GraphType;

import org.junit.Test;

import view.Main;

public class TestLoadDataController {

	@Test
	public void testLoadDataController() {
		Main main = new Main();
		Model model = main.getModel();
		
		assertTrue((main.getModel().getDataSet().count()==0));
		String filePath = "src"+File.separator+"resources"+File.separator+"data10Points.txt";
		LoadDataController ldc = new LoadDataController(model);
		assertTrue(ldc.loadFromFile(new File(filePath), main) );
		assertTrue(model.getDataSet().count() == 10);
		
		assertEquals(main.getModel().getDataSet().getDataPointAt(5).getX(), -62.19, 0.01);
		
		main.getChoosenGraphComboBox().setSelectedItem("Column");
		model.setGraphType(GraphType.COLUMN);
		ldc = new LoadDataController(model);
		assertTrue(ldc.loadFromFile(new File(filePath), main) );
		
		assertEquals(main.getModel().getDataSet().count(), 10);
		assertEquals(main.getModel().getDataSet().getDataPointAt(5).getX(), -62.19, 0.01);
		
	}

}
