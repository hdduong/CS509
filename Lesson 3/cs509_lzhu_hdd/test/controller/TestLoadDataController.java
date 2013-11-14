package controller;

import java.io.File;
import javax.swing.*;
import views.Main;
import views.MainForm;
import junit.framework.TestCase;

public class TestLoadDataController extends TestCase {
	Main main;
	MainForm mainForm;
	JFileChooser fileChooser;
	public void setUp(){
		main= new Main();
		main.setVisible(true); 
		mainForm = main.getMainForm();
		fileChooser = mainForm.getFileChooser();
	}
	
	public void testLoadDataController(){
		assertTrue((mainForm.getDataSet().set.size()==0));
		String filePath = "src"+File.separator+"resources"+File.separator+"dataToBeLoad.txt";
		//String filePath = "C:\\Users\\lzhu\\Documents\\GitHub\\CS509\\Lesson 3\\cs509_lzhu_hdd\\src\\resources\\dataToBeLoad.txt";
		fileChooser.setSelectedFile(new File(filePath));
		LoadDataController controller = new LoadDataController(mainForm.getDataSet());
		assertTrue(controller.operation(0, mainForm));
		
		assertEquals(mainForm.getDataSet().set.size(),6);
		assertEquals(mainForm.getDataSet().set.get(5).getY(),-8.9); 
		assertFalse(controller.operation(1, mainForm));
	}
}
