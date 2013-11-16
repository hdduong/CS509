package controller;

import javax.swing.JCheckBox;

import view.GraphOptionPanel;
import view.GraphPanel;
import view.Main;
import model.Model;

public class UpdateBGHorizontalLine {
	Model model;
	
	public UpdateBGHorizontalLine(Model m) {
		this.model = m;
	}
	
	public void process(Main mainFrm) {
		JCheckBox chkShowHorizonalLine = mainFrm.getGraphOptionPanel().getShowBackgroundHorizonal();
		
		if (chkShowHorizonalLine.isSelected()) {
			model.getGraph().setHorizontalLine(true);
		}
		else {
			model.getGraph().setHorizontalLine(false);
		}
		
		mainFrm.getGraphPanel().repaint();
		
	}
}
