package controller;

import javax.swing.JCheckBox;

import view.GraphOptionPanel;
import view.Main;
import model.CartesianPlot;
import model.ColumnGraph;
import model.Model;
import model.Model.GraphType;

public class EnableGraphController {
	Model model;
	
	public EnableGraphController (Model m) {
		this.model = m;
	}
	
	public void process(Main mainFrm, GraphOptionPanel graphOption) {
		String graphType = (String) mainFrm.getChoosenGraphComboBox().getSelectedItem();
		
		// Whenever a new graph type chosen, set all options to be chosen
		JCheckBox showBGHorizontal = graphOption.getShowBackgroundHorizonal();
		showBGHorizontal.setSelected(true);
		
		JCheckBox showXYLabel = graphOption.getShowXYLabels();
		showXYLabel.setSelected(true);
		
		  
		if (graphType.equals("Cartersian")) {
			
			model.setGraphType(GraphType.CARTESIAN);
			
			JCheckBox showTrendLine = graphOption.getShowTrendLine();
			showTrendLine.setVisible(true);
			showTrendLine.setSelected(true);
			 
			JCheckBox showEquation = graphOption.getShowEquation();
			showEquation.setVisible(true);
			showEquation.setEnabled(true);
			showEquation.setSelected(true);
			
			model.setGraph(new CartesianPlot(model.getDataSet(), (double)mainFrm.getGraphPanel().getWidth(), (double)mainFrm.getGraphPanel().getHeight() ) );
			mainFrm.getGraphPanel().repaint();
		}
		else if (graphType.equals("Column")) {
			model.setGraphType(GraphType.COLUMN);
			
			JCheckBox showTrendLine = graphOption.getShowTrendLine();
			showTrendLine.setVisible(false);
			showTrendLine.setSelected(false);
			
			JCheckBox showEquation = graphOption.getShowEquation();
			showEquation.setVisible(false);
			showEquation.setSelected(false);
			
			model.setGraph(new ColumnGraph(model.getDataSet(), (double)mainFrm.getGraphPanel().getWidth(), (double)mainFrm.getGraphPanel().getHeight() ) );
			mainFrm.getGraphPanel().repaint();
		}
	}
}
