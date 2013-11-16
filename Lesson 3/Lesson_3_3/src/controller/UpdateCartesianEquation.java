package controller;

import javax.swing.JCheckBox;

import view.Main;
import model.CartesianPlot;
import model.Model;
import model.Model.GraphType;

public class UpdateCartesianEquation {
	Model model;
	
	public UpdateCartesianEquation(Model m) {
		this.model = m;
	}
	
	public void process(Main mainFrm) {
		JCheckBox chkEquationBox = mainFrm.getGraphOptionPanel().getShowEquation();
		
		if (model.getGraphType() == GraphType.CARTESIAN) {
			
			CartesianPlot cartesianPlot = (CartesianPlot)model.getGraph();
			cartesianPlot.setTrendLine(true);
			
			if (chkEquationBox.isSelected()) {
				cartesianPlot.setEquaiton(true);
			}
			else {
				cartesianPlot.setEquaiton(false);
			}
		}
		
		mainFrm.getGraphPanel().repaint();
	}
}
