package controller;

import static org.junit.Assert.*;

import model.Model;

import org.junit.Test;

import view.GraphOptionPanel;
import view.Main;

public class TestUpdateBGHorizontalLine {

	@Test
	public void testUpdateBGHorizontalLine() {
		Main main = new Main();
		Model model  = main.getModel();
		
		main.setVisible(true);
		GraphOptionPanel graphOptionPanel = main.getGraphOptionPanel();
		graphOptionPanel.setVisible(true);
		
		UpdateBGHorizontalLine ulc = new UpdateBGHorizontalLine(model);
		graphOptionPanel.getShowBackgroundHorizonal().setSelected(true);
		ulc.process(main);
		graphOptionPanel.getShowBackgroundHorizonal().setSelected(false);
		ulc.process(main);
	}

}
