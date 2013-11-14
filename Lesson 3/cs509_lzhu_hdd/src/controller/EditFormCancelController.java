package controller;

import views.EditForm;;

public class EditFormCancelController {

	
	
	public void act(EditForm editForm) {
		editForm.setCanceled(true);
		editForm.setVisible(false);
	}
}
