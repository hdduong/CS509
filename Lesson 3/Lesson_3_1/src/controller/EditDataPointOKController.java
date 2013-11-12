package controller;

import javax.swing.DefaultListModel;

import view.EditDataPointForm;
import view.ManipuldateDataForm;
import model.DataPoint;
import model.Model;

public class EditDataPointOKController {
	Model model;
	
	public EditDataPointOKController(Model m) {
		this.model = m;
	}
	
	public boolean act(EditDataPointForm edForm, ManipuldateDataForm manForm){
		String editValueXStr = edForm.getEditX().getText();
		String editValueYStr = edForm.getEditY().getText();
		
		String xyValueString = editValueXStr + "," + editValueYStr;
		
		if ( (editValueXStr == null) || (editValueYStr == null) ) { return false; }
		
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
		
		return true;
	}
	
}
