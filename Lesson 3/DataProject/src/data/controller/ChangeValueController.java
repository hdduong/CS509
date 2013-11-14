package data.controller;

import data.model.Model;
import data.view.DataWindow;
import data.view.EnterDataForm;

public class ChangeValueController {

	Model model;
	
	public ChangeValueController(Model model) {
		this.model = model;
	}

	public boolean act(DataWindow dataWindow) {
		// prepare to get a new value from user and change in the model AND redisplay
		EnterDataForm evf = new EnterDataForm();
		evf.setModal(true);  // STOP EVERYTHING UNTIL USER SELECTS OK or CANCEL
		evf.setVisible(true); 
		
		// WAIT until user does something
		if (evf.wasCanceled()) { return false; }
		return takeAction(dataWindow, evf);
	}
	
	public boolean takeAction (DataWindow dataWindow, EnterDataForm evf) {
		String newValue = evf.getTextField().getText();

		// update model
		model.setValue(newValue);
		
		// refresh boundary
		dataWindow.getTextField().setText(newValue);
		return true;
	}

}
