package heineman.controller;

import javax.swing.DefaultListModel;
import heineman.view.*;
import heineman.model.*;

public class AddWordController {
	Model model;
	
	public AddWordController(Model model) {
		this.model = model;
	}
	
	public boolean act(MainForm mainForm) {
		String wordToAdd = mainForm.getWordField().getText();
		mainForm.getWordField().setText("");
		
		if (wordToAdd.length() == 0) { return false; }
		
		int idx = model.addWord(wordToAdd);
		
		DefaultListModel list = (DefaultListModel) mainForm.getWordList().getModel();
		list.add(idx, wordToAdd);
		return true;
	}
}
