package sample;

import java.awt.Graphics;

import javax.swing.*;

public class Base extends JPanel {

	Drawer drawer;
	
	public Base(Drawer d) {
		drawer = d;
	}
	
	public void setDrawer (Drawer d) {
		this.drawer = d;
	}
	
	// This is the method that you must implement in a JPanel
	public void paintComponent (Graphics g) {
		// and the first statement MUST BE THIS
		super.paintComponent(g);
		
		if (drawer == null) { return; }
		
		drawer.draw(g);
	}
	
}
