package controller;


import views.*;
import junit.framework.TestCase;

public class TestUpdateAfterEditController extends TestCase {

	Main main;
	MainForm mainForm;
	EditForm editForm;
	
	public void setUp(){
		main= new Main();
		main.setVisible(true); 
		mainForm = main.getMainForm();
		editForm = (EditForm) mainForm.getEditDialog();
		mainForm.getXToAdd().setText("122");
		mainForm.getYToAdd().setText("156.7"); 
		AddDataPointController controller = new AddDataPointController(mainForm.getDataSet());
		controller.act(mainForm);
	}
	
	public void testUpdateAfterEditController(){
		assertEquals(122.0, mainForm.getDataSet().set.get(0).getX());
		mainForm.getDataList().setSelectedIndex(0);
		editForm.getNewX().setText("2");
		editForm.getNewY().setText("3");
		UpdateAfterEditController controller = new UpdateAfterEditController (mainForm.getDataSet());
		assertTrue(controller.act(mainForm));
		assertEquals(2.0, mainForm.getDataSet().set.get(0).getX());
		
	}
	
	public void testUpdateAfterEditControllerWithNoSelection(){
	
		UpdateAfterEditController controller = new UpdateAfterEditController (mainForm.getDataSet());
		assertFalse(controller.act(mainForm)); 
		
	}
	
	public void testUpdateAfterEditControllerWithEmptyInput(){
		assertEquals(122.0, mainForm.getDataSet().set.get(0).getX());
		mainForm.getDataList().setSelectedIndex(0);
		editForm.getNewX().setText(" ");
		editForm.getNewY().setText("");
		UpdateAfterEditController controller = new UpdateAfterEditController (mainForm.getDataSet());
		assertFalse(controller.act(mainForm)); 
		
	}
}