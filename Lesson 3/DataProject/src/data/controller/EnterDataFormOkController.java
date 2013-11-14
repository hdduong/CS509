package data.controller;

import data.view.EnterDataForm;

public class EnterDataFormOkController {

	// NO MODEL required
	
	public void act(EnterDataForm enterDataForm) {
		enterDataForm.setCanceled(false);
		enterDataForm.setVisible(false);
	}
}
