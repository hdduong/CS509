package controller;

import static org.junit.Assert.*;

import model.Model;

import org.junit.Test;

import view.EditDataPointForm;
import view.Main;

public class TestEditDataPointOKController {

	@Test
	public void testEditDataPointOKController() {
		Main main = new Main();
		Model model = main.getModel();
		
		EditDataPointForm edForm = new EditDataPointForm(model);
		EditDataPointOKController edpc = new EditDataPointOKController(model);
		edpc.act(edForm);
	}

}
