package heineman.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import heineman.view.*;
import heineman.model.*;

public class AlternativeWordController implements ActionListener {
	Model model;
	MainForm mainForm;
	
	public AlternativeWordController(MainForm form, Model model) {
		this.mainForm = form;
		this.model = model;
	}
	
	public void actionPerformed(ActionEvent e) {
		String wordToAdd = mainForm.getWordField().getText();
		mainForm.getWordField().setText("");
		
		if (wordToAdd.length() == 0) { return; }
		
		int idx = model.addWord(wordToAdd);
		
		DefaultListModel list = (DefaultListModel) mainForm.getWordList().getModel();
		list.add(idx, wordToAdd);
	}
}
