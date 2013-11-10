package heineman.controller;

import static org.junit.Assert.*;

import javax.swing.JTextField;

import org.junit.Test;
import heineman.model.*;
import heineman.view.Main;

public class TestAddWordController {

	@Test
	public void testControllerOperation() {
		Main main = new Main();
		main.setVisible(true);
		
		Model model = main.getModel();
		
		// prepare the GUI
		JTextField input = main.getMainForm().getWordField();
		input.setText("Test");
		
		// invoke controller
		AddWordController awc = new AddWordController(model);
		assertTrue (awc.act(main.getMainForm()));
		
		assertEquals (1, model.size());
		assertEquals ("Test", model.getNth(0));
		
	}

}
