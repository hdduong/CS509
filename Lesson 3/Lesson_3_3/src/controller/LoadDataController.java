package controller;

import java.io.EOFException;
import java.io.File;

import javax.swing.*;

import view.Main;

import model.CartesianPlot;
import model.ColumnGraph;
import model.DataPoint;
import model.DataSet;
import model.Model;
import model.Model.GraphType;



public class LoadDataController {
	
	Model model;
	
	public LoadDataController(Model m){
		this.model = m;
	}
	
	public boolean act(Main mainForm){
		
		JFileChooser load = new JFileChooser();
		
	 	if( load.showOpenDialog(mainForm) != JFileChooser.APPROVE_OPTION) {
	 		//System.out.println("Load Data was Cancelled!.");
	 		return false;
	 	}
		
		return loadFromFile(load.getSelectedFile(), mainForm);
		
	}
	 
	
	public boolean loadFromFile(File input, Main mainForm){
		try{
			System.out.println("Opening: " + input.getName());
           
			String filePath = input.getAbsolutePath();
    		
			this.model.getDataSet().setBlankDataSet();			//remove previous data
			// clear data from list
			DefaultListModel list = (DefaultListModel)mainForm.getManipuldateDataForm().getListDataPoint().getModel();
			list.removeAllElements();
			
			this.model.getDataSet().loadDataSetFromFile(filePath); 
    		
    		list = (DefaultListModel)mainForm.getManipuldateDataForm().getListDataPoint().getModel();
    		for( int i=0;i< model.getDataSet().count(); i++ ){
    			DataPoint dp = model.getDataSet().getDataPointAt(i);
    			list.add(i, (dp.getX() + "," + dp.getY())); 
    		}
    		
    		// load data have to look dropdown graph options
    		String graphType = (String) mainForm.getChoosenGraphComboBox().getSelectedItem();
    		if (graphType.equals("Cartersian")) {
    			model.setGraphType(GraphType.CARTESIAN);
    			
    			JCheckBox showTrendLine = mainForm.getGraphOptionPanel().getShowTrendLine();
    			showTrendLine.setVisible(true);
    			showTrendLine.setSelected(true);
    			
    			JCheckBox showEquation = mainForm.getGraphOptionPanel().getShowEquation();
    			showEquation.setVisible(true);
    			showEquation.setSelected(true);
    			
    			model.setGraph(new CartesianPlot(model.getDataSet(), (double)mainForm.getGraphPanel().getWidth(), (double)mainForm.getGraphPanel().getHeight() ) );
    		}
    		else if (graphType.equals("Column")) { 
    			model.setGraphType(GraphType.COLUMN);
    			
    			JCheckBox showTrendLine = mainForm.getGraphOptionPanel().getShowTrendLine();
    			showTrendLine.setVisible(false);
    			showTrendLine.setSelected(false);
    			
    			JCheckBox showEquation = mainForm.getGraphOptionPanel().getShowEquation();
    			showEquation.setVisible(false);
    			showEquation.setSelected(false);
    			
    			model.setGraph(new ColumnGraph(model.getDataSet(), (double)mainForm.getGraphPanel().getWidth(), (double)mainForm.getGraphPanel().getHeight() ) );
    		}
    		
    		mainForm.getGraphPanel().repaint();
    	   
    	} 
		catch (Exception e) {
			e.printStackTrace();
			 return false;
		}
		return true;
	}
	

}
