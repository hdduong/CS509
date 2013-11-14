package data.controller;

import data.view.EnterDataForm;

public class EnterDataFormCancelController {

	// NO MODEL required
	
	public void act(EnterDataForm enterDataForm) {
		enterDataForm.setCanceled(true);
		enterDataForm.setVisible(false);
	}
}
