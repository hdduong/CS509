package controller;

import view.EditDataPointForm;
import view.ManipuldateDataForm;
import model.Model;
import java.lang.*;


public class OpenDataPointDialogController {
	Model model;
	
	public OpenDataPointDialogController(Model m) {
		this.model = m;
	}
	
	public void act(ManipuldateDataForm manForm) {
		
		int index = manForm.getListDataPoint().getSelectedIndex();
		//System.out.println(index);
		
		if ( (index >= 0) && (index < model.getDataSet().count() ) )  {
			EditDataPointForm edForm = new EditDataPointForm(model, manForm);
			edForm.setModal(true);
			edForm.setVisible(true);
		}		
	}
}
