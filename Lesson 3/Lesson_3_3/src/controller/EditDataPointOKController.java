package controller;


import view.EditDataPointForm;
import model.Model;

public class EditDataPointOKController {
	Model model;
	
	public EditDataPointOKController(Model m) {
		this.model = m;
	}
	
	public void act(EditDataPointForm edForm){
		edForm.setCanceled(false);
		edForm.setVisible(false);

	}
	
}
