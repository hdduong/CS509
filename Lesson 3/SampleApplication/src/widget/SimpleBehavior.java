package widget;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JApplet;

public class SimpleBehavior extends JApplet implements MouseListener, MouseMotionListener {

	Point start = null;
	boolean mouseDown = false;
	Point here = null;
	
	public void init() {
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	
	public void paint (Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		
		if (start != null) {
			g.fillOval(start.x-2, start.y-2, 4, 4);
		}
		
		if (mouseDown) {
			double dist = Math.sqrt((here.x-start.x)*(here.x-start.x) + (here.y-start.y)*(here.y-start.y));
			g.drawString("" + dist, here.x, here.y);
		}
	}

	public void mousePressed(MouseEvent e) { 
		start = e.getPoint();
		mouseDown = true;
	}

	public void mouseReleased(MouseEvent e) {
		start = null;
		mouseDown = false;
	}

	public void mouseEntered(MouseEvent e) { }
	public void mouseClicked(MouseEvent e) { }
	public void mouseExited(MouseEvent e) {	}

	public void mouseDragged(MouseEvent e) {
		here = e.getPoint();
		repaint(); // force repaint
	}

	public void mouseMoved(MouseEvent e) {
		here = e.getPoint();
		repaint(); // force repaint
	}
}