package controller;

import static org.junit.Assert.*;

import java.io.File;

import javax.swing.JComboBox;

import model.Model;

import org.junit.Test;

import view.EditDataPointForm;
import view.GraphOptionPanel;
import view.GraphPanel;
import view.Main;
import view.ManipuldateDataForm;

public class TestUpdateCartesianTrendLine {

	@Test
	public void testUpdateCartesianTrendLine() {
		Main main = new Main();
		Model model = main.getModel();
		
		ManipuldateDataForm manForm = main.getManipuldateDataForm();
		manForm.setVisible(true);
		
		GraphPanel graphPanel = main.getGraphPanel();
		graphPanel.setVisible(true);
		
		GraphOptionPanel graphOptionPanel = main.getGraphOptionPanel();
		graphPanel.setVisible(true);
		graphOptionPanel.getShowBackgroundHorizonal().setSelected(true);
		graphOptionPanel.getShowEquation().setSelected(true);
		graphOptionPanel.getShowTrendLine().setSelected(true);
		graphOptionPanel.getShowXYLabels().setSelected(true);
		
		assertTrue((main.getModel().getDataSet().count()==0));
		String filePath = "src"+File.separator+"resources"+File.separator+"data10Points.txt";
		LoadDataController ldc = new LoadDataController(model);
		assertTrue(ldc.loadFromFile(new File(filePath), main) );
		assertTrue(model.getDataSet().count() == 10);
		
		JComboBox graphChoosen = main.getChoosenGraphComboBox();
		graphChoosen.setSelectedItem("Cartersian");
		
		UpdateCartesianTrendLine uctl = new UpdateCartesianTrendLine(model);
		uctl.process(model, main);
		
		graphOptionPanel.getShowBackgroundHorizonal().setSelected(false);
		graphOptionPanel.getShowEquation().setSelected(false);
		graphOptionPanel.getShowTrendLine().setSelected(false);
		graphOptionPanel.getShowXYLabels().setSelected(false);
		uctl.process(model, main);
		
		
	}

}
