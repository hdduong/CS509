package heineman.controller;

import javax.swing.DefaultListModel;
import heineman.model.Model;
import heineman.view.MainForm;

public class RemoveSelectedController {
	Model model;
	
	public RemoveSelectedController(Model model) {
		this.model = model;
	}
	
	public boolean act(MainForm mainForm) {
		int[] row = mainForm.getWordList().getSelectedIndices();
		if (row.length == 0) { 
			return false;
		}
		
		DefaultListModel list = (DefaultListModel) mainForm.getWordList().getModel();
		for (int idx = row.length-1; idx >= 0; idx--) {
			list.remove(row[idx]);
			model.removeWord(row[idx]);
		}
		
		return true;
	}
}
