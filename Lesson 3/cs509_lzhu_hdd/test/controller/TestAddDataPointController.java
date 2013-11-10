package controller;

import javax.swing.*;
import junit.framework.TestCase; 

import views.*;


public class TestAddDataPointController extends TestCase{
	Main main;
	MainForm mainForm;
	
	public void setUp(){
		main= new Main();
		main.setVisible(true); 
		mainForm = main.getMainForm();
	}
	
	
	public void testAddDataPointController(){
	
		mainForm.getXToAdd().setText("122");
		mainForm.getYToAdd().setText("156.7");
		 
		AddDataPointController controller = new AddDataPointController(mainForm.getDataSet());
		assertTrue(controller.act(mainForm));
		assertEquals(mainForm.getDataSet().set.size(),1);
		assertEquals(mainForm.getDataSet().set.get(0).getX(),122.0);
		assertEquals(mainForm.getDataSet().set.get(0).getY(),156.7);
	}
	

	public void testAddDataPointControllerWithEmptyInput(){
	
		mainForm.getXToAdd().setText(" ");
		mainForm.getYToAdd().setText("");
		 
		AddDataPointController controller = new AddDataPointController(mainForm.getDataSet());
		assertFalse(controller.act(mainForm));
		assertEquals(mainForm.getDataSet().set.size(),0); 
	}
	
}
