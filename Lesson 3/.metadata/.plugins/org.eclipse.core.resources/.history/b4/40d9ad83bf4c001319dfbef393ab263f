package controller;

import javax.swing.DefaultListModel;

import model.DataSet;
import views.*;

public class UpdateAfterEditController {

	DataSet data;
	EditForm editDialog;
	
	public UpdateAfterEditController(DataSet ds){
		data = ds;
	}
	
	public boolean act(MainForm mainForm){
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
			editDialog.setVisible(false);
			return true;
			}catch(NumberFormatException | NullPointerException e){
				e.printStackTrace();
			}
		editDialog.setVisible(false);
		return false;
		
	}
	
	
}
