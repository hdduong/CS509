package controller;

import view.EditDataPointForm;

public class EditDataPointCancelController {
	
	public EditDataPointCancelController() {
		return;
	}
	
	public void act(EditDataPointForm edDataPointForm) {
		edDataPointForm.setCanceled(true);
		edDataPointForm.setVisible(false);
	}
}
