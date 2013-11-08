package controller;

import javax.swing.DefaultListModel;

import views.MainForm;
import model.*;

public class AddDataPointController {
	DataSet data;
	
	public AddDataPointController(DataSet ds){
		data = ds;
	}
	
	public boolean act(MainForm mainForm){
		
		String newX=mainForm.getXToAdd().getText();
		String newY=mainForm.getYToAdd().getText();
		if(newX.length()==0 || newY.length()==0)
			return false;
		
		mainForm.getXToAdd().setText("");
		mainForm.getYToAdd().setText("");
		try{
		double x=Double.parseDouble(newX);
		double y=Double.parseDouble(newY);
		if(data.addDataPoint(x,y)){
			DefaultListModel list = (DefaultListModel)mainForm.getDataList().getModel();
			String dataPointToAdd =  x+" , "+y ;
			list.add(data.set.size()-1, dataPointToAdd);
			return true;
		   }
		}catch(NumberFormatException | NullPointerException e){
			e.printStackTrace();
			}
		return false;
	}
	
	
	
}
