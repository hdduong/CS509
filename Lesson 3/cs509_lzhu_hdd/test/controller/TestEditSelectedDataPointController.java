package controller;

import views.EditForm;
import views.Main;
import views.MainForm;
import junit.framework.TestCase;

public class TestEditSelectedDataPointController extends TestCase {

	Main main;
	MainForm mainForm;
	EditForm editForm;
	
	public void setUp(){
		main= new Main();
		main.setVisible(true); 
		mainForm = main.getMainForm();
		mainForm.getXToAdd().setText("122");
		mainForm.getYToAdd().setText("156.7"); 
		AddDataPointController controller = new AddDataPointController(mainForm.getDataSet());
		controller.act(mainForm);
		 editForm=mainForm.getEditDialog();
	}
	
	public void testEditSelectedDataPointController(){
		assertEquals(mainForm.getDataSet().set.size(),1);
		mainForm.getDataList().setSelectedIndex(0);		 
		editForm.getNewX().setText("2");
		editForm.getNewY().setText("3");
		editForm.setCanceled(false);
		EditSelectedDataPointController controller = new EditSelectedDataPointController(mainForm.getDataSet());
		assertTrue(controller.operate(mainForm, editForm)); 
		assertEquals(2.0, mainForm.getDataSet().set.get(0).getX());
	}
	
	public void testEditSelectedDataPointControllerWithNoSelection(){
			 
		EditSelectedDataPointController controller = new EditSelectedDataPointController(mainForm.getDataSet());
		assertFalse(controller.operate(mainForm, editForm)); 
	}
	 
	public void testEditSelectedDataPointControllerWithCancel(){
		 
		EditSelectedDataPointController controller = new EditSelectedDataPointController(mainForm.getDataSet());
		assertFalse(controller.operate(mainForm, editForm)); 
	}

}
