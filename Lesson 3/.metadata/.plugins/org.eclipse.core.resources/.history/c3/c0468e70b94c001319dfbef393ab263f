package controller;

import java.io.File;

import javax.swing.JFileChooser;

import views.Main;
import views.MainForm;
import junit.framework.TestCase;

public class TestSaveDataController extends TestCase {

	Main main;
	MainForm mainForm;
	JFileChooser fileChooser;
	
	public void setUp(){
		main= new Main();
		main.setVisible(true); 
		mainForm = main.getMainForm();
		fileChooser = mainForm.getFileChooser();

		mainForm.getXToAdd().setText("122");
		mainForm.getYToAdd().setText("156.7"); 
		AddDataPointController controller = new AddDataPointController(mainForm.getDataSet());
		controller.act(mainForm);
	
	}
	
	public void testSaveDataController(){ 
		//String filePath = "src"+File.separator+"resources"+File.separator+"dataToBeLoad.txt";
		String filePath = "C:\\Users\\lzhu\\Documents\\GitHub\\CS509\\Lesson 3\\cs509_lzhu_hdd\\src\\resources\\EmptyFile.txt";
		fileChooser.setSelectedFile(new File(filePath));
		SaveDataController controller = new SaveDataController(mainForm.getDataSet());
		assertTrue(controller.act(mainForm));
		
		assertEquals(mainForm.getDataSet().set.size(),1);
	}

}
