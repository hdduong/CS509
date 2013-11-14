package data.controller;

import data.model.Model;
import data.view.DataWindow;
import data.view.EnterDataForm;
import junit.framework.TestCase;

public class TestChangeValueController extends TestCase {

	public void testModification() {
		// PREPARE
		DataWindow dw = new DataWindow();
		Model model = dw.getModel();
		
		dw.setVisible(true); 
		
		EnterDataForm edf = new EnterDataForm();
		edf.getTextField().setText("newValue");
		edf.setCanceled(false);
		
		// TAKE ACTION
		ChangeValueController cvc = new ChangeValueController(model);
		
		assertTrue (cvc.takeAction (dw, edf));
		
		// VALIDATE
		assertEquals ("newValue", model.getValue());
			
	}
}
