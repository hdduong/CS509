package controller;

import view.EditDataPointForm;

public class EditDataPointCancelController {
	
	public EditDataPointCancelController() {
		return;
	}
	
	public void act(EditDataPointForm edDataPointForm) {
		edDataPointForm.getEditX().setText("");
		edDataPointForm.getEditY().setText("");
		
		edDataPointForm.setVisible(false);
	}
}
