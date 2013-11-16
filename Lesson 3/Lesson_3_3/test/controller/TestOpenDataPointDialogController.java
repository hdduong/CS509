package controller;

import static org.junit.Assert.*;

import java.io.File;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

import model.Model;

import org.junit.Test;

import view.EditDataPointForm;
import view.GraphOptionPanel;
import view.GraphPanel;
import view.Main;
import view.ManipuldateDataForm;

public class TestOpenDataPointDialogController {

	@Test
	public void testOpenDataPointDialogController() {
		Main main = new Main();
		Model model = main.getModel();
		
		ManipuldateDataForm manForm = main.getManipuldateDataForm();
		manForm.setVisible(true);
		
		GraphPanel graphPanel = main.getGraphPanel();
		graphPanel.setVisible(true);
		
		GraphOptionPanel graphOptionPanel = main.getGraphOptionPanel();
		graphPanel.setVisible(true);
		
		EditDataPointForm edForm = new EditDataPointForm(model);
		edForm.setVisible(true);
		
		assertTrue((main.getModel().getDataSet().count()==0));
		String filePath = "src"+File.separator+"resources"+File.separator+"data10Points.txt";
		LoadDataController ldc = new LoadDataController(model);
		assertTrue(ldc.loadFromFile(new File(filePath), main) );
		assertTrue(model.getDataSet().count() == 10);
		
		OpenDataPointDialogController opdpdc = new OpenDataPointDialogController(model);
		assertFalse(opdpdc.act(manForm, main));
		assertFalse(opdpdc.takeAction(main, manForm, edForm));
		
		JList jList = main.getManipuldateDataForm().getListDataPoint();
		jList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		int[] select = {2,3};
		jList.setSelectedIndices(select);
		
		opdpdc = new OpenDataPointDialogController(model);
		edForm.getEditX().setText("");
		edForm.getEditY().setText("");
		assertFalse(opdpdc.takeAction(main, manForm, edForm));
		
		edForm.getEditX().setText("77.77asdfasdf");
		edForm.getEditY().setText("99.99");
		assertFalse(opdpdc.takeAction(main, manForm, edForm));
		
		edForm.getEditX().setText("77.77");
		edForm.getEditY().setText("99.99");
		assertTrue(opdpdc.takeAction(main, manForm, edForm));
		
		assertEquals(77.77,model.getDataSet().getDataPointAt(2).getX(), 0.01);
		assertEquals(99.99,model.getDataSet().getDataPointAt(2).getY(), 0.01);

	}

}
