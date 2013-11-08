package heineman.controller;

import javax.swing.DefaultListModel;
import heineman.view.*;
import heineman.model.*;

public class RemoveWordController {
	Model model;
	
	public RemoveWordController(Model model) {
		this.model = model;
	}
	
	public boolean act(MainForm mainForm) {
		String wordToRemove = mainForm.getWordField().getText();
		mainForm.getWordField().setText("");
		
		int idx = model.removeWord(wordToRemove);
		if (idx == -1) {
			return false;
		}
		
		DefaultListModel list = (DefaultListModel) mainForm.getWordList().getModel();
		list.remove(idx);
		return true;
	}
}
