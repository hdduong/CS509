package controller;

import view.EditDataPointForm;
import view.Main;
import view.ManipuldateDataForm;
import model.DataPoint;
import model.Model;
import java.lang.*;

import javax.swing.DefaultListModel;


public class OpenDataPointDialogController {
	Model model;
	
	
	public OpenDataPointDialogController(Model m) {
		this.model = m;
	}
	
	public boolean act(ManipuldateDataForm manForm, Main mainForm) {
		
		int index = manForm.getListDataPoint().getSelectedIndex();
		if (index == -1) { return false; } // no index was selected;
		
		EditDataPointForm edForm = new EditDataPointForm(this.model);
		edForm.setModal(true);
		edForm.setVisible(true);

		// WAIT until user does something
		if (edForm.wasCanceled()) { return false; }
		
		return takeAction(mainForm, manForm, edForm);
	}
	
	
	public boolean takeAction (Main mainForm, ManipuldateDataForm manForm, EditDataPointForm edForm) {
		
		int []rows = manForm.getListDataPoint().getSelectedIndices();
		if(rows.length == 0) { return false; }
		
		//only edit the first one;
		int index = rows[0];
		
		String editValueXStr = edForm.getEditX().getText();
		String editValueYStr = edForm.getEditY().getText();
		
		String xyValueString = editValueXStr + "," + editValueYStr;
		
		//if ( (editValueXStr == null) || (editValueYStr == null) ) { return false; }
		if ( (editValueXStr.equals(null)) || (editValueYStr.equals(null)) ) { return false; }
		if ( (editValueXStr.equals("")) || (editValueYStr.equals("")) ) { return false; }
		
		try {
			double editValueX = Double.parseDouble(editValueXStr);
			double editValueY = Double.parseDouble(editValueYStr);
			
			DataPoint dtPoint = new DataPoint(editValueX, editValueY);
			
			int selectedIndex = manForm.getListDataPoint().getSelectedIndex();
			
			DefaultListModel list = (DefaultListModel)manForm.getListDataPoint().getModel();
			list.removeElementAt(selectedIndex);
			list.add(selectedIndex, xyValueString);
			
			
			model.getDataSet().removeDataPointAt(selectedIndex);
			model.getDataSet().addDataPointAt(selectedIndex,dtPoint);
			
			edForm.setVisible(false);
			
			mainForm.getGraphPanel().repaint();
			
		} catch (NumberFormatException | NullPointerException e){
				e.printStackTrace();
				return false;
		}

		return true;
	}
	
	
}
