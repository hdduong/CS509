package controller;

import static org.junit.Assert.*;

import model.Model;

import org.junit.Test;

import view.EditDataPointForm;
import view.Main;

import controller.EditDataPointCancelController;

public class TestEditDataPointCancelController {

	@Test
	public void testEditDataPointCancelController() {
		
		Main main = new Main();
		Model model = main.getModel();
		
		EditDataPointForm edForm = new EditDataPointForm(model);
		EditDataPointCancelController edpc = new EditDataPointCancelController();
		edpc.act(edForm);
	}

}
