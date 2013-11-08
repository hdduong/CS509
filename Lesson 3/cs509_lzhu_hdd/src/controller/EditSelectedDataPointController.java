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
		int [] row = mainForm.getDataList().getSelectedIndices();
		if(row.length==0)
			return false;
		
		EditForm editDialog=(EditForm) mainForm.getEditDialog();
		editDialog.setVisible(true);
		return true;
		
	}
	 
}
