package controller;

import views.Main;
import views.MainForm;
import junit.framework.TestCase;

public class TestDeleteDataPoint extends TestCase {
	Main main;
	MainForm mainForm;
	
	public void setUp(){
		main= new Main();
		main.setVisible(true); 
		mainForm = main.getMainForm();
		mainForm.getXToAdd().setText("122");
		mainForm.getYToAdd().setText("156.7"); 
		AddDataPointController controller = new AddDataPointController(mainForm.getDataSet());
		controller.act(mainForm);
	}
	
	public void testDeleteDataPoint(){
		assertEquals(mainForm.getDataSet().set.size(),1);
		mainForm.getDataList().setSelectedIndex(0);		 
		DeleteSelectedDataPointController controller = new DeleteSelectedDataPointController(mainForm.getDataSet());
		assertTrue(controller.act(mainForm));
		assertEquals(mainForm.getDataSet().set.size(),0);
	}
	
	public void testDeleteDataPointWithoutSelection(){
		assertEquals(mainForm.getDataSet().set.size(),1); 
		DeleteSelectedDataPointController controller = new DeleteSelectedDataPointController(mainForm.getDataSet());
		assertFalse(controller.act(mainForm));
		assertEquals(mainForm.getDataSet().set.size(),1);
	}
}
