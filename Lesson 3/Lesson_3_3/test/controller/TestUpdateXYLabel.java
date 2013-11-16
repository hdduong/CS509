package controller;

import static org.junit.Assert.*;

import model.Model;

import org.junit.Test;

import view.GraphOptionPanel;
import view.Main;

public class TestUpdateXYLabel {

	@Test
	public void testUpdateXYLabel() {
		Main main = new Main();
		Model model  = main.getModel();
		
		main.setVisible(true);
		GraphOptionPanel graphOptionPanel = main.getGraphOptionPanel();
		graphOptionPanel.setVisible(true);
		
		UpdateXYLabel ulc = new UpdateXYLabel(model);
		graphOptionPanel.getShowXYLabels().setSelected(true);
		ulc.process(main);
		graphOptionPanel.getShowXYLabels().setSelected(false);
		ulc.process(main);
		
	}

}
