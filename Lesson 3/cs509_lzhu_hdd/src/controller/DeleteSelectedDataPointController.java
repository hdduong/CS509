package controller;

import javax.swing.*;

import model.DataSet;
import views.MainForm;

public class DeleteSelectedDataPointController {

	DataSet data;
	
	public DeleteSelectedDataPointController(DataSet ds){
		data = ds;
	}
	
	public boolean act(MainForm mainForm){
		int [] row = mainForm.getDataList().getSelectedIndices();
		if(row.length==0)
			return false;
		DefaultListModel list = (DefaultListModel)mainForm.getDataList().getModel();
		for(int i=row.length-1;i>=0;i--){
			list.remove(row[i]);
			data.deleteDataPoint(i);
		}
		
	
		return true;
	}
	
}
