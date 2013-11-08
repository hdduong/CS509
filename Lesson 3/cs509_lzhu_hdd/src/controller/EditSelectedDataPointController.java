package controller;

import javax.swing.DefaultListModel;

import model.DataSet;
import views.MainForm;

public class EditSelectedDataPointController {

	DataSet data;
	
	public EditSelectedDataPointController(DataSet ds){
		data = ds;
	}
	
	public boolean act(MainForm mainForm){
		int [] row = mainForm.getDataList().getSelectedIndices();
		if(row.length==0)
			return false;
		DefaultListModel list = (DefaultListModel)mainForm.getDataList().getModel();
		 //only edit the first one;
		JDailoughe
			list.remove(row[i]);
			data.deleteDataPoint(i);
		 
		 
	}
	
	
}
