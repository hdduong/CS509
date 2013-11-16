package controller;

import java.lang.*;

import view.GraphOptionPanel;
import view.Main;
import view.ManipuldateDataForm;
import model.CartesianPlot;
import model.ColumnGraph;
import model.DataPoint;
import model.Model;
import model.Model.GraphType;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;

public class AddDataPointController {
	Model model;
	
	public AddDataPointController(Model m) {
		this.model = m;
	}
	 
	public boolean act(ManipuldateDataForm manForm, Main main) {
		String xValueStr = manForm.getAddX().getText();
		String yValueStr = manForm.getAddY().getText();
		manForm.getAddX().setText("");
		manForm.getAddY().setText("");
		 
		if ( (xValueStr == null) || (yValueStr == null)) { return false;}
 
		try {
			double xValue = Double.parseDouble(xValueStr);
			double yValue = Double.parseDouble(yValueStr);
			
			DataPoint dPoint = new DataPoint(xValue,yValue);
			
			int index = model.getDataSet().addDataPoint(dPoint);
			String lstDataPoint = dPoint.toString();
			
			DefaultListModel  list =  (DefaultListModel)manForm.getListDataPoint().getModel();
			list.add(index, lstDataPoint);
			
			//get GraphOption from UI
			GraphOptionPanel graphOption = main.getGraphOptionPanel();
			JCheckBox showTrendLine = graphOption.getShowTrendLine();
			JCheckBox showEquation = graphOption.getShowEquation();
			JCheckBox showXYLabels = graphOption.getShowXYLabels();
			JCheckBox showBGHorizontalLine = graphOption.getShowBackgroundHorizonal();
			
			
			//if ( (model.getGraphType() != GraphType.CARTESIAN) || (model.getGraphType() != GraphType.COLUMN) ) {
			if ( (model.getDataSet().count() == 1 )) {
				
				// This is for adding the first point
				String graphType = (String) main.getChoosenGraphComboBox().getSelectedItem();
				
				
				if (graphType.equals("Cartersian")) {
					
					model.setGraphType(GraphType.CARTESIAN);

					CartesianPlot cartesianPlot = new CartesianPlot(model.getDataSet(), (double)main.getGraphPanel().getWidth(), (double)main.getGraphPanel().getHeight() );
					model.setGraph(cartesianPlot);
					
					
					if (showTrendLine.isSelected()) {
						cartesianPlot.setTrendLine(true);
					}
					else {
						cartesianPlot.setTrendLine(false);
					}
					
					
					if (showEquation.isSelected()) {
						cartesianPlot.setEquaiton(true);
					}
					else {
						cartesianPlot.setEquaiton(false);
					}
					
					
					if (showXYLabels.isSelected()) {
						cartesianPlot.setXYLabels(true);
					}
					else {
						cartesianPlot.setXYLabels(false);
					}
					
					
					if (showBGHorizontalLine.isSelected()) {
						cartesianPlot.setHorizontalLine(true);
					}
					else {
						cartesianPlot.setHorizontalLine(false);
					}
					
					main.getGraphPanel().repaint();
				}
				else if (graphType.equals("Column")) {
					model.setGraphType(GraphType.COLUMN);
					
					ColumnGraph columnGraph = new ColumnGraph(model.getDataSet(), (double)main.getGraphPanel().getWidth(), (double)main.getGraphPanel().getHeight() );
					model.setGraph(columnGraph);
					
					if (showXYLabels.isSelected()) {
						columnGraph.setXYLabels(true);
					}
					else {
						columnGraph.setXYLabels(false);
					}
					
					
					if (showBGHorizontalLine.isSelected()) {
						columnGraph.setHorizontalLine(true);
					}
					else {
						columnGraph.setHorizontalLine(false);
					}
	
					model.setGraph(columnGraph);
					main.getGraphPanel().repaint();
				}
				
			}
			else {
				main.getGraphPanel().repaint();
			}
		    
		} catch (NumberFormatException | NullPointerException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
