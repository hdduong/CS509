package controller;

import views.Main;
import views.MainForm;
import junit.framework.TestCase;

public class TestEditSelectedDataPointController extends TestCase {

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
	
	public void testEditSelectedDataPointController(){
		assertEquals(mainForm.getDataSet().set.size(),1);
		mainForm.getDataList().setSelectedIndex(0);		 
		EditSelectedDataPointController controller = new EditSelectedDataPointController(mainForm.getDataSet());
		assertTrue(controller.act(mainForm)); 
	}
	
	public void testEditSelectedDataPointControllerWithNoSelection(){
			 
		EditSelectedDataPointController controller = new EditSelectedDataPointController(mainForm.getDataSet());
		assertFalse(controller.act(mainForm)); 
	}
	 

}