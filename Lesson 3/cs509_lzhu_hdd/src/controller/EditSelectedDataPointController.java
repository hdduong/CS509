package controller;

import javax.swing.*;
import model.DataSet;
import views.*; 

public class EditSelectedDataPointController {

	DataSet data;
	
	public EditSelectedDataPointController(DataSet ds){
		data = ds;
	}
	
	public boolean act(MainForm mainForm){
 
		
		EditForm editDialog=(EditForm) mainForm.getEditDialog();
		editDialog.setModal(true); // STOP EVERYTHING UNTIL USER SELECTS OK or CANCEL
		editDialog.setVisible(true); 
	 
		
		// WAIT until user does something
		if (editDialog.wasCanceled())
		    return false;  
		
		return operate(mainForm, editDialog);
		
		
	}
	 
	public boolean operate(MainForm mainForm, EditForm editDialog){
		DefaultListModel list1 = (DefaultListModel)mainForm.getDataList().getModel(); 
		list1.set(0, "2343223432");
		int [] row = mainForm.getDataList().getSelectedIndices();
		if(row.length==0)
			return false;
		//only edit the first one;
		int index=row[0];
		DefaultListModel list = (DefaultListModel)mainForm.getDataList().getModel(); 
		editDialog=(EditForm) mainForm.getEditDialog();
		try{
			double x=Double.parseDouble(editDialog.getNewX().getText());
			double y=Double.parseDouble(editDialog.getNewY().getText());
			String dataPointToAdd =  x+" , "+y ;
			list.set(index, dataPointToAdd);
			data.editDataPoint(index, x, y); 
			return true;
			}catch(NumberFormatException | NullPointerException e){
				e.printStackTrace(); 
				return false;
			}
		
		
	}
}
