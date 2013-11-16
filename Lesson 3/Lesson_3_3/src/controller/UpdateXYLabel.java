package controller;

import javax.swing.JCheckBox;

import view.GraphOptionPanel;
import view.GraphPanel;
import view.Main;
import model.ColumnGraph;
import model.Model;

public class UpdateXYLabel {
	Model model;
	
	public UpdateXYLabel(Model m) {
		this.model = m;
	}
	
	public void process(Main frmMain) {
		JCheckBox chkShowXYLabel = frmMain.getGraphOptionPanel().getShowXYLabels();
		
		if (chkShowXYLabel.isSelected()) {
			model.getGraph().setXYLabels(true);
		}
		else {
			model.getGraph().setXYLabels(false);
		}
		
		frmMain.getGraphPanel().repaint();
		 
	}
	
}
