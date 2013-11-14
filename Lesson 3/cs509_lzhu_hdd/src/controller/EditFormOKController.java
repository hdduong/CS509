package controller;

import views.EditForm;

public class EditFormOKController {

	
	public void act(EditForm editForm) {
		editForm.setCanceled(false);
		editForm.setVisible(false);
	}
}
