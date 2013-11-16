package controller;

import static org.junit.Assert.*;

import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import model.DataSet;
import model.Model;

import org.junit.Test;

import view.GraphOptionPanel;
import view.GraphPanel;
import view.Main;
import view.ManipuldateDataForm;

public class TestDeleteDataPointController {

	@Test
	public void testDeleteDataPoinNoSelected() {
		Main main = new Main();
		main.setVisible(true);
		
		Model model = main.getModel();
		DataSet ds = model.getDataSet(); 
		
		//prepare the GUI
		ManipuldateDataForm manForm = main.getManipuldateDataForm();
		manForm.setVisible(true);
		 
		JTextField addX = manForm.getAddX();
		JTextField addY = manForm.getAddY();
		
		GraphPanel graphPanel = main.getGraphPanel();
		graphPanel.setVisible(true);
		 
		GraphOptionPanel graphOptionPanel = main.getGraphOptionPanel();
		graphOptionPanel.setVisible(true);
		
		addX.setText("2.56");
		addY.setText("7.98");
		AddDataPointController adpc = new AddDataPointController(model);
		assertTrue(adpc.act(manForm, main));
		assertEquals(1, model.getDataSet().count());
		
		addX.setText("20.4");
		addY.setText("1.94");
		adpc = new AddDataPointController(model);
		assertTrue(adpc.act(manForm, main));
		
		DeleteDataPointController ddpc = new DeleteDataPointController(model);
		assertFalse(ddpc.act(manForm, main));
		
	}
	
	@Test
	public void testDeleteDataPoinWithSelected() {
		Main main = new Main();
		main.setVisible(true);
		main.getManipuldateDataForm().setVisible(true);
		
		Model model = main.getModel();
		DataSet ds = model.getDataSet(); 
		
		
		//prepare the GUI
		ManipuldateDataForm manForm = main.getManipuldateDataForm();
		manForm.setVisible(true);
		
		//add the first points
		JTextField addX = manForm.getAddX();
		JTextField addY = manForm.getAddY();
		
		addX.setText("2.56");
		addY.setText("7.98");
		AddDataPointController adpc = new AddDataPointController(model);
		assertTrue(adpc.act(manForm, main));
		assertEquals(1, model.getDataSet().count());
		
		addX.setText("20.4");
		addY.setText("1.94");
		adpc = new AddDataPointController(model);
		assertTrue(adpc.act(manForm, main));
		
		addX.setText("3.22");
		addY.setText("25.1");
		adpc = new AddDataPointController(model);
		assertTrue(adpc.act(manForm, main));
		
		
		addX.setText("56.22");
		addY.setText("9.15");
		adpc = new AddDataPointController(model);
		assertTrue(adpc.act(manForm, main));
		
		assertEquals(4, model.getDataSet().count());
		
		GraphPanel graphPanel = main.getGraphPanel();
		graphPanel.setVisible(true);
		 
		GraphOptionPanel graphOptionPanel = main.getGraphOptionPanel();
		graphOptionPanel.setVisible(true);
		
		main.getManipuldateDataForm().getListDataPoint().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		int[] select = {2,3};
		main.getManipuldateDataForm().getListDataPoint().setSelectedIndices(select);
		//JOptionPane.showMessageDialog(null, new JScrollPane(main.getManipuldateDataForm().getListDataPoint()));
		
		DeleteDataPointController ddpc = new DeleteDataPointController(model);
		assertTrue(ddpc.act(main.getManipuldateDataForm(), main));
		assertEquals(2, model.getDataSet().count());
		
	}

}
