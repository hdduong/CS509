package controller;

import static org.junit.Assert.*;

import java.io.File;

import model.Model;

import org.junit.Test;

import view.Main;

public class TestSaveDataController {

	@Test
	public void testSaveDataController() {
		Main main = new Main();
		Model model = main.getModel();
		
		assertTrue((main.getModel().getDataSet().count()==0));
		String filePath = "src"+File.separator+"resources"+File.separator+"data10Points.txt";
		LoadDataController ldc = new LoadDataController(model);
		assertTrue(ldc.loadFromFile(new File(filePath), main) );
		
		assertEquals(main.getModel().getDataSet().count(), 10);
		assertEquals(main.getModel().getDataSet().getDataPointAt(5).getX(),-62.19, 0.01);

			
		String emptyFilePath = "";
		SaveDataController sdc = new SaveDataController(model);
		assertFalse(sdc.saveToFile(new File(emptyFilePath), main));
		 
		emptyFilePath ="src"+File.separator+"resources"+File.separator+"emptyFile.txt";
		SaveDataController sdc1 = new SaveDataController(model);
		assertTrue(sdc1.saveToFile(new File(emptyFilePath), main));
	}

}
