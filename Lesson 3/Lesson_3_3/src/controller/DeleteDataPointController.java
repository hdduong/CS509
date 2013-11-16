package controller;

import javax.swing.DefaultListModel;

import view.Main;
import view.ManipuldateDataForm;
import model.Model;

public class DeleteDataPointController {
	Model model;
	
	public DeleteDataPointController(Model m){
		this.model = m;	
	}
	 
	public boolean act(ManipuldateDataForm manForm, Main main) {
		
		int [] rowIndexes = manForm.getListDataPoint().getSelectedIndices();
		
		if (rowIndexes.length == 0) {
			return false;
		}
		
		int newSize = 0;
		DefaultListModel list = (DefaultListModel)manForm.getListDataPoint().getModel();
		
		for (int i = rowIndexes.length - 1; i >= 0 ; i--) {
			list.removeElementAt(rowIndexes[i]);
			newSize = model.getDataSet().removeDataPointAt(rowIndexes[i]);
		}

		main.getGraphPanel().repaint();
		
		return true;
	}
} 
