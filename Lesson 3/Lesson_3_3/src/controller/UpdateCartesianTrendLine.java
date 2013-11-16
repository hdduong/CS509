package controller;

import javax.swing.JCheckBox;

import view.Main;
import model.CartesianPlot;
import model.Model;
import model.Model.GraphType;


public class UpdateCartesianTrendLine {
	Model model;
	
	public UpdateCartesianTrendLine(Model m) {
		this.model = m;
	}
	
	public void process(Model m, Main mainFrm) {
		JCheckBox chkTrendLineBox = mainFrm.getGraphOptionPanel().getShowTrendLine();
		JCheckBox chkEquationBox = mainFrm.getGraphOptionPanel().getShowEquation();
		
		if (model.getGraphType() == GraphType.CARTESIAN) {
			if (chkTrendLineBox.isSelected()) {
				chkEquationBox.setEnabled(true);
				CartesianPlot cartesianPlot = (CartesianPlot)model.getGraph();
				cartesianPlot.setTrendLine(true);
				if (chkEquationBox.isSelected()) {
					cartesianPlot.setEquaiton(true);
				}
				else {
					cartesianPlot.setEquaiton(false);
				}
			}
			else {
				chkEquationBox.setEnabled(false);
				CartesianPlot cartesianPlot = (CartesianPlot)model.getGraph();
				cartesianPlot.setTrendLine(false);
				cartesianPlot.setEquaiton(false);
			}
		}
		
		mainFrm.getGraphPanel().repaint();
	}
}
