package heineman.controller;

import javax.swing.JFileChooser;

import java.util.*;
import java.io.*;

import heineman.view.*;
import heineman.model.*;

public class SaveWordsController {
	Model model;

	public SaveWordsController(Model model) {
		this.model = model;
	}

	/**
	 * This method only interacts with the JFileChooser boundary object to secure the
	 * file to be used for saving.
	 */
	public boolean act(MainForm mainForm) {
		JFileChooser save = new JFileChooser();
		if (save.showSaveDialog(mainForm) != JFileChooser.APPROVE_OPTION) {
			return false;
		}

		return saveToFile(save.getSelectedFile());
	}

	/** 
	 * Make this a separate method so it can be tested.
	 */
	boolean saveToFile(File output) {
		try {
			PrintStream ps = new PrintStream(output);
			for (Iterator<String> it = model.iterator(); it.hasNext(); ) {
				String word = it.next();
				ps.println(word);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
}
