package controller;

import static org.junit.Assert.*;

import java.awt.Dialog.ModalExclusionType;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import model.CartesianPlot;
import model.Model;

import org.junit.Test;

import view.GraphOptionPanel;
import view.GraphPanel;
import view.Main;
import view.ManipuldateDataForm;

public class TestAddDataPointController {

	@Test
	public void testAddNullDataPointController() {
		Main main = new Main();
		main.setVisible(true);
		
		Model model = main.getModel();
		
		//prepare the GUI
		ManipuldateDataForm manForm = main.getManipuldateDataForm();
		
		JTextField addX = manForm.getAddX();
		JTextField addY = manForm.getAddY();
		
		// null datapoint
		addX.setText("");
		addY.setText("");
		AddDataPointController adpc = new AddDataPointController(model);
		assertFalse(adpc.act(manForm, main));
	}

	 
	@Test
	public void testAddIncorrectFormatDataPointController() {
		Main main = new Main();
		main.setVisible(true);
		
		Model model = main.getModel();
		
		//prepare the GUI
		ManipuldateDataForm manForm = main.getManipuldateDataForm();
		
		JTextField addX = manForm.getAddX();
		JTextField addY = manForm.getAddY();
		
		// incorrect format
		addX.setText("12fghfhgjh");
		addY.setText("21.33");
		AddDataPointController adpc = new AddDataPointController(model);
		assertFalse(adpc.act(manForm, main));
	}
	
	@Test
	public void testAddCorrectDataPointWithCartersian() {
		Main main = new Main();
		main.setVisible(true);
		
		Model model = main.getModel();
		
		//prepare the GUI
		ManipuldateDataForm manForm = main.getManipuldateDataForm();
		manForm.setVisible(true);
		
		GraphPanel graphPanel = main.getGraphPanel();
		graphPanel.setVisible(true);
		 
		GraphOptionPanel graphOptionPanel = main.getGraphOptionPanel();
		graphOptionPanel.setVisible(true);
		
		JComboBox graphChoosen = main.getChoosenGraphComboBox();
		graphChoosen.setSelectedItem("Cartersian");
		
		JTextField addX = manForm.getAddX();
		JTextField addY = manForm.getAddY();
		
		addX.setText("8.93");
		addY.setText("21.33");
		
		AddDataPointController adpc = new AddDataPointController(model);
		assertTrue(adpc.act(manForm, main));
		
		assertEquals(1, model.getDataSet().count());
		assertEquals(8.93, model.getDataSet().getDataPointAt(0).getX(), 0.01);
		
		addX.setText("1.34");
		addY.setText("11.73");
		
		adpc = new AddDataPointController(model);
		assertTrue(adpc.act(manForm, main));
		
		assertEquals(2, model.getDataSet().count());
		assertEquals(1.34, model.getDataSet().getDataPointAt(1).getX(), 0.01);
	}
	
	@Test
	public void testAddCorrectDataPointWithColumn() {
		Main main = new Main();
		main.setVisible(true);
		
		Model model = main.getModel();
		
		//prepare the GUI
		ManipuldateDataForm manForm = main.getManipuldateDataForm();
		manForm.setVisible(true);
		
		GraphPanel graphPanel = main.getGraphPanel();
		graphPanel.setVisible(true);
		  
		GraphOptionPanel graphOptionPanel = main.getGraphOptionPanel();
		graphOptionPanel.setVisible(true);
		
		JComboBox graphChoosen = main.getChoosenGraphComboBox();
		graphChoosen.setSelectedItem("Column");
		
		JTextField addX = manForm.getAddX();
		JTextField addY = manForm.getAddY();
		
		addX.setText("8.93");
		addY.setText("21.33");
		
		AddDataPointController adpc = new AddDataPointController(model);
		assertTrue(adpc.act(manForm, main));
		
		assertEquals(1, model.getDataSet().count());
		assertEquals(8.93, model.getDataSet().getDataPointAt(0).getX(), 0.01);
		
		addX.setText("1.34");
		addY.setText("11.73");
		
		adpc = new AddDataPointController(model);
		assertTrue(adpc.act(manForm, main));
		
		assertEquals(2, model.getDataSet().count());
		assertEquals(1.34, model.getDataSet().getDataPointAt(1).getX(), 0.01);
	}
}
