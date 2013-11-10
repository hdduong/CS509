package example;

import java.awt.Graphics;

import javax.swing.JPanel;

public class MySpecialPanel extends JPanel {

	String model;
	
	/**
	 * Create the panel.
	 */
	public MySpecialPanel(String someValue) {
		this.model = someValue;
	}
	
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		
		if (model == null) { return; }
		
		g.drawString (model, 80, 100);
		g.drawLine(10, 10, 50, 70);
	}

}
